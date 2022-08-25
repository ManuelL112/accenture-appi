package org.accenture.api.pruebaApi.application.rest.support;

import org.accenture.api.pruebaApi.application.rest.support.handler.RestException;
import org.accenture.api.pruebaApi.commons.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

public interface AbstractRestSupportController {

    default URI createURI(String path, Object id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(path)
                .buildAndExpand(id)
                .toUri();
    }

    default void validateResult(BindingResult result) {
        if (result.hasErrors()) {
            String message = Optional.ofNullable(result.getFieldError()).map(FieldError::getDefaultMessage)
                    .orElse(Constants.VALIDATION_DEFAULT_MESSAGE);

            throw new RestException(message,result.getAllErrors(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
