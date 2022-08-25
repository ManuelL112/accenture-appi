package org.accenture.api.pruebaApi.domain.model.support.pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQueryDTO {

    private String query;

    private Integer page;

    private Integer size;

    private String order;

    private String columnOrder;
}
