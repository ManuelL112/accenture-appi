package org.accenture.api.pruebaApi.infrastructure.adapter.mapper.support;

import org.accenture.api.pruebaApi.commons.ErrorException;
import org.accenture.api.pruebaApi.domain.model.support.Model;
import org.accenture.api.pruebaApi.infrastructure.repository.domain.support.Entities;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ObjectFactory;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.TargetType;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class JpaMapper {

    @PersistenceContext
    protected EntityManager em;

    @ObjectFactory
    public <E extends Entities> E reference(Model<? extends Serializable> dto, @TargetType Class<E> entityClass) {
        try {
            return (dto.getId() != null) ? em.getReference(entityClass, dto.getId()) : entityClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new ErrorException("An error has occurred trying to get reference entity by @id.", e);
        }
    }
}
