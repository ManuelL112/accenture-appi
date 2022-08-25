package org.accenture.api.pruebaApi.application.rest.support.handler;

import lombok.extern.slf4j.Slf4j;
import org.accenture.api.pruebaApi.application.rest.support.handler.message.ApiError;
import org.accenture.api.pruebaApi.commons.ErrorException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Slf4j
@ControllerAdvice
public class GlobalRestExceptionHandler {

    private static final Object[] DEFAULT_MESSAGE_PARAMS = null;
    private static final List<? extends Serializable> EMPTY_ERROR_LIST = Collections.emptyList();

    private final MessageSource messageSource;

    public GlobalRestExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ApiError> resolveErrorException(HttpServletRequest request, HttpServletResponse response, ErrorException e, Locale locale) {
        return buildResponseEntity(e, locale, HttpStatus.INTERNAL_SERVER_ERROR, EMPTY_ERROR_LIST);
    }

    @ExceptionHandler(RestException.class)
    public ResponseEntity<ApiError> resolveRestException(HttpServletRequest request, HttpServletResponse response, RestException e, Locale locale) {
        return buildResponseEntity(e, locale, e.getStatus(), e.getErrors());
    }

    private ResponseEntity<ApiError> buildResponseEntity(ErrorException e, Locale locale, HttpStatus httpStatus, List<? extends Serializable> errors) {
        String message = resolveMessage(e.getMessage(), locale);
        log.error(message, e);
        return ResponseEntity.status(httpStatus).body(
                ApiError.builder()
                        .code(e.getCode())
                        .message(message)
                        .errors(errors)
                        .build());
    }

    private String resolveMessage(String message, Locale locale) {
        return messageSource.getMessage(message, DEFAULT_MESSAGE_PARAMS, locale);
    }
}
