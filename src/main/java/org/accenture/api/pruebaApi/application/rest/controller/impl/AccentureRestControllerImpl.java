package org.accenture.api.pruebaApi.application.rest.controller.impl;

import org.accenture.api.pruebaApi.application.rest.controller.AccentureRestController;
import org.accenture.api.pruebaApi.application.rest.model.PermissionModelMapper;
import org.accenture.api.pruebaApi.application.rest.model.request.PermissionControllerRequest;
import org.accenture.api.pruebaApi.application.rest.model.request.PermissionControllerSearchRequest;
import org.accenture.api.pruebaApi.application.rest.model.response.PermissionControllerResponse;
import org.accenture.api.pruebaApi.domain.model.support.Permission;
import org.accenture.api.pruebaApi.domain.model.support.Photo;
import org.accenture.api.pruebaApi.domain.service.AccentureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prueba-api")
public class AccentureRestControllerImpl implements AccentureRestController {

    @Autowired
    private AccentureService accentureService;

    private final PermissionModelMapper permissionModelMapper;

    public AccentureRestControllerImpl() {
        this.permissionModelMapper = PermissionModelMapper.INSTANCE;
    }


    @Override
    @PostMapping("/register")
    public ResponseEntity<PermissionControllerResponse> register(@RequestBody PermissionControllerRequest permissionControllerRequest) {
        Permission permission = accentureService.register(permissionModelMapper.toPermission(permissionControllerRequest));
        return ResponseEntity.created(createURI("/{permissionCode}", permission.getCode())).body(permissionModelMapper.toResponse(permission));
    }

    @Override
    @GetMapping("/photos/{userId}")
    public List<Photo> findPhotosByUser(@PathVariable("userId") Long userId) {
        return accentureService.findPhotosByUser(userId);
    }

    @Override
    @GetMapping("/permissions")
    public List<PermissionControllerResponse> findAll() {
        return permissionModelMapper.toResponses(accentureService.findAll());
    }

    @Override
    @GetMapping("/permissions/search")
    public List<PermissionControllerResponse> search(PermissionControllerSearchRequest permissionControllerSearchRequest) {
        return permissionModelMapper.toResponses(accentureService.search(permissionControllerSearchRequest));
    }
}
