package org.accenture.api.pruebaApi.infrastructure.adapter;

import lombok.extern.slf4j.Slf4j;
import org.accenture.api.pruebaApi.application.rest.model.request.PermissionControllerSearchRequest;
import org.accenture.api.pruebaApi.application.rest.model.response.PermissionControllerResponse;
import org.accenture.api.pruebaApi.commons.Constants;
import org.accenture.api.pruebaApi.commons.ErrorException;
import org.accenture.api.pruebaApi.domain.model.support.Album;
import org.accenture.api.pruebaApi.domain.model.support.Permission;
import org.accenture.api.pruebaApi.domain.model.support.Photo;
import org.accenture.api.pruebaApi.domain.model.support.Post;
import org.accenture.api.pruebaApi.domain.model.support.User;
import org.accenture.api.pruebaApi.domain.service.AccentureService;
import org.accenture.api.pruebaApi.infrastructure.adapter.mapper.PermissionAdapterMapper;
import org.accenture.api.pruebaApi.infrastructure.repository.PermissionJpaRepository;
import org.accenture.api.pruebaApi.infrastructure.repository.domain.PermissionEntity;
import org.accenture.api.pruebaApi.infrastructure.repository.specification.PermissionSearchSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AccentureAdapterService implements AccentureService {

    @Autowired
    List<Photo> photos;

    @Autowired
    List<Album> albums;

    @Autowired
    List<User> users;

    @Autowired
    List<Post> posts;

    @Autowired
    private PermissionJpaRepository permissionJpaRepository;


    private final PermissionAdapterMapper mapper;

    public AccentureAdapterService(PermissionAdapterMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Permission register(Permission permission) {

        existsAlbum(permission.getAlbumId());
        existsUser(permission.getUserId());
        try {
            PermissionEntity permissionEntity = mapper.toEntity(permission);
            PermissionEntity newPermission = permissionJpaRepository.save(permissionEntity);
            return mapper.toDTO(newPermission);
        } catch (Exception e) {
            throw new ErrorException(Constants.ERROR_SAVE);
        }


    }

    private void existsAlbum(Long albumId) {
        albums.stream().filter(album -> album.getId().equals(albumId)).findFirst().orElseThrow(() -> new ErrorException(Constants.VALIDATION_ALBUM, "doesntExist"));
    }

    private void existsUser(Long userId) {
        users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElseThrow(() -> new ErrorException(Constants.VALIDATION_USERS, "doesntExist"));
    }


    @Override
    public List<Photo> findPhotosByUser(Long userId) {

        List<Photo> result = new ArrayList<>();

        List<Album> albumsList = albums.stream().filter(photo -> photo.getUserId().equals(userId)).collect(Collectors.toList());
        albumsList.forEach(album -> {
            result.addAll(photos.stream().filter(photo -> photo.getAlbumId().equals(album.getUserId())).collect(Collectors.toList()));
        });
        return result;
    }

    @Override
    public List<Permission> findAll() {
        return mapper.toDTOS(permissionJpaRepository.findAll());
    }

    @Override
    public List<Permission> search(PermissionControllerSearchRequest permissionControllerSearchRequest) {
        Specification<PermissionEntity> specification = null;
        if(!ObjectUtils.isEmpty(permissionControllerSearchRequest.getAlbumId()))
            specification = PermissionSearchSpecification.buildAlbum(permissionControllerSearchRequest.getAlbumId());

        if(!ObjectUtils.isEmpty(permissionControllerSearchRequest.getUserId()))
            specification = PermissionSearchSpecification.buildUser(permissionControllerSearchRequest.getUserId());

        if(!ObjectUtils.isEmpty(permissionControllerSearchRequest.getPermission()))
            specification = PermissionSearchSpecification.buildPermission(permissionControllerSearchRequest.getPermission());

        return mapper.toDTOS(permissionJpaRepository.findAll(specification));
    }
}