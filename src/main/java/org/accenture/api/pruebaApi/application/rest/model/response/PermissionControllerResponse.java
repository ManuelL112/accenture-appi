package org.accenture.api.pruebaApi.application.rest.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.accenture.api.pruebaApi.domain.model.support.enums.PermissionEnum;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Create permissions response")
public class PermissionControllerResponse {

    @Schema(name = "code")
    private String code;

    @Schema(name = "userId")
    private Long userId;

    @Schema(name = "albumId")
    private Long albumId;

    @Schema(name = "permission")
    private List<PermissionEnum> permission;
}
