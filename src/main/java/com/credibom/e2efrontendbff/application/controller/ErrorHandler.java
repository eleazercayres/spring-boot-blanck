package com.credibom.e2efrontendbff.application.controller;

import static org.springframework.http.ResponseEntity.status;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.credibom.e2efrontendbff.infrastructure.exception.CreditException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ErrorHandler {
   
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Map createErrorMap(String message) {
		Map map = new HashMap();
        map.put("error", message);
        return map;
    }

    @ExceptionHandler(CreditException.class)
    public ResponseEntity catalogNotFoundException(CreditException e) {
        log.error("EXCEPTION: {}", e);
        log.error(e.getMessage(), e);
        return status(HttpStatus.NOT_FOUND).body(createErrorMap(e.getMessage()));
    }

}
