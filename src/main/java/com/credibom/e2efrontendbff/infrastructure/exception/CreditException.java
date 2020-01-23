package com.credibom.e2efrontendbff.infrastructure.exception;

import org.springframework.http.HttpStatus;

public class CreditException extends IntegrationException {

	private static final long serialVersionUID = 1L;

	public CreditException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

}
