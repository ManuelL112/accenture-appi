package org.accenture.api.pruebaApi.infrastructure.repository.domain.support;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Entities<I extends Serializable> extends Auditable {

    @Column(name = "id")
    protected I id;

    @Id
    @Column(name = "code", length = 50, nullable = false)
    protected String code;
}
