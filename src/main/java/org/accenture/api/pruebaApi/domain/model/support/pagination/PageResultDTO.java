package org.accenture.api.pruebaApi.domain.model.support.pagination;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResultDTO<T> {

    private List<T> data;

    private Long totalRows;

    private Integer pageSize;

    private Integer pageNumber;
}
