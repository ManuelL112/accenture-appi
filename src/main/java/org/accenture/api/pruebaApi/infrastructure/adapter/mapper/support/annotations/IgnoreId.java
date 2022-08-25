package org.accenture.api.pruebaApi.infrastructure.adapter.mapper.support.annotations;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "id", ignore = true)
public @interface IgnoreId {

}