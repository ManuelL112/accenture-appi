package org.accenture.api.pruebaApi.application.rest.support.handler.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.accenture.api.pruebaApi.commons.Message;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Schema(name = "API Error Message")
public class ApiError extends Message {

    public static final String API_ERROR_DEFAULT_CODE = "000000";

    @Schema(name = "errors")
    @JsonProperty("errors")
    private List<? extends Serializable> errors;

    @Builder
    public ApiError(String code, String message, List<? extends Serializable> errors) {
        super(code, message);
        this.errors = errors;
    }
}