package org.accenture.api.pruebaApi.infrastructure.repository.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.accenture.api.pruebaApi.infrastructure.repository.domain.support.Entities;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "permission")
public class PermissionEntity extends Entities<Long> {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "album_id")
    private Long albumId;

    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "permission_user", joinColumns = @JoinColumn(name = "permission_code"))
    @Column(name = "permission")
    private List<String> permission;

}
