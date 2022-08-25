package org.mutualser.zonaser.subdomain.application.rest.support.pagination.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Pagination request")
public class PageRequest {

    @Schema(name = "query")
    private String query;

    @Schema(name = "page", description = "Send zero for first page")
    private Integer page;

    @Schema(name = "size", description = "Send page size")
    private Integer size;

    @Schema(name = "order", description = "Send ASC or DESC")
    private String order;

    @Schema(name = "columnOrder", description = "Send column name for order by")
    private String columnOrder;
}
