package org.accenture.api.pruebaApi.application.rest.support.handler;

import lombok.Getter;
import lombok.Setter;
import org.accenture.api.pruebaApi.commons.ErrorException;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@SuppressWarnings("serial")
public class RestException extends ErrorException {

    private final List<? extends Serializable> errors;

    private final HttpStatus status;

    public RestException(String message, HttpStatus status) {
	    super(message);
	    this.status = status;
        this.errors = Collections.emptyList();
    }

    public RestException(String message, String code, HttpStatus status) {
	    super(message, code);
	    this.status = status;
        this.errors = Collections.emptyList();
    }

    public RestException(String message, List<? extends Serializable> errors, HttpStatus status) {
        super(message);
        this.errors = errors;
        this.status = status;
    }

    public RestException(String message, String code, List<? extends Serializable> errors, HttpStatus status) {
	    super(message, code);
	    this.status = status;
        this.errors = errors;
    }
}