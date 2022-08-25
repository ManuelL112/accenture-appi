package org.mutualser.zonaser.subdomain.application.rest.support.pagination.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(name = "Pagination response")
public class PageResponse<T> {

    @Schema(name = "data")
    private List<T> data;

    @Schema(name = "totalRows")
    private Long totalRows;

    @Schema(name = "pageSize")
    private Integer pageSize;

    @Schema(name = "pageNumber")
    private Integer pageNumber;
}
