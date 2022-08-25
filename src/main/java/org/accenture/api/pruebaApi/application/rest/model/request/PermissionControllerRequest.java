package org.accenture.api.pruebaApi.application.rest.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.accenture.api.pruebaApi.domain.model.support.enums.PermissionEnum;

import java.util.List;

@Getter
@Setter
@Schema(name = "Create permissions")
public class PermissionControllerRequest {


    private Long albumId;
    private Long userId;
    private List<PermissionEnum> permission;

}
