package org.accenture.api.pruebaApi.infrastructure.repository.specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.accenture.api.pruebaApi.domain.model.support.enums.PermissionEnum;
import org.accenture.api.pruebaApi.infrastructure.repository.domain.PermissionEntity;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PermissionSearchSpecification {

    public static Specification<PermissionEntity> buildAlbum(Long album) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.and(criteriaBuilder.equal(root.get("albumId"), album)));
    }

    public static Specification<PermissionEntity> buildUser(Long user) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.and(criteriaBuilder.equal(root.get("userId"), user)));
    }

    public static Specification<PermissionEntity> buildPermission(PermissionEnum permission) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.and(root.join("permission").in(permission.name())));
    }
}