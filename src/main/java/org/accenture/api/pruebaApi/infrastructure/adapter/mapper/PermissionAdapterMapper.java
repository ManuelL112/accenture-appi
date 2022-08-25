package org.accenture.api.pruebaApi.infrastructure.adapter.mapper;

import org.accenture.api.pruebaApi.domain.model.support.Permission;
import org.accenture.api.pruebaApi.infrastructure.adapter.mapper.support.JpaMapper;
import org.accenture.api.pruebaApi.infrastructure.adapter.mapper.support.annotations.IgnoreAuditable;
import org.accenture.api.pruebaApi.infrastructure.adapter.mapper.support.annotations.IgnoreId;
import org.accenture.api.pruebaApi.infrastructure.adapter.mapper.support.annotations.UniqueId;
import org.accenture.api.pruebaApi.infrastructure.repository.domain.PermissionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = JpaMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface PermissionAdapterMapper {


    Permission toDTO(PermissionEntity permissionEntity);

    List<Permission> toDTOS(List<PermissionEntity> permissionEntities);

    @IgnoreId
    @IgnoreAuditable
    @UniqueId
    PermissionEntity toEntity(Permission permission);

}
