package org.accenture.api.pruebaApi.application.rest.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.accenture.api.pruebaApi.domain.model.support.enums.PermissionEnum;

@Getter
@Setter
@Schema(name = "Serach permissions")
public class PermissionControllerSearchRequest {


    private Long albumId;
    private Long userId;
    private PermissionEnum permission;

}
