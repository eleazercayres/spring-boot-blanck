package com.credibom.e2efrontendbff.infrastructure.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

public abstract class IntegrationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Getter
    private final transient Map content;

    @Getter
    private final HttpStatus httpStatus;

    IntegrationException(String message, HttpStatus httpStatus) {
        this(message, httpStatus, null);
    }

    private IntegrationException(String message, HttpStatus httpStatus, Map content) {
        super(message);
        this.httpStatus = httpStatus;
        this.content = content;
    }

}