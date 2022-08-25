package org.accenture.api.pruebaApi.domain.service;

import org.accenture.api.pruebaApi.application.rest.model.request.PermissionControllerSearchRequest;
import org.accenture.api.pruebaApi.domain.model.support.Permission;
import org.accenture.api.pruebaApi.domain.model.support.Photo;

import java.util.List;

public interface AccentureService {

    public Permission register(Permission permission);

    public List<Photo> findPhotosByUser(Long userId);

    public List<Permission> findAll();

    public List<Permission> search(PermissionControllerSearchRequest permissionControllerSearchRequest);


}
