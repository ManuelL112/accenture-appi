package org.accenture.api.pruebaApi.domain.model.support;

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
public class Permission {

    private String code;
    private Long userId;
    private Long albumId;
    private List<PermissionEnum> permission;
}
