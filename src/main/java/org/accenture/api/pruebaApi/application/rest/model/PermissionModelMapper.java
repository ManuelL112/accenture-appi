package org.accenture.api.pruebaApi.application.rest.model;

import org.accenture.api.pruebaApi.application.rest.model.request.PermissionControllerRequest;
import org.accenture.api.pruebaApi.application.rest.model.response.PermissionControllerResponse;
import org.accenture.api.pruebaApi.domain.model.support.Permission;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface PermissionModelMapper {

    PermissionModelMapper INSTANCE = Mappers.getMapper(PermissionModelMapper.class);


    Permission toPermission(PermissionControllerRequest permissionControllerRequest);

    PermissionControllerResponse toResponse(Permission permission);

    List<PermissionControllerResponse> toResponses(List<Permission> permission);



}
