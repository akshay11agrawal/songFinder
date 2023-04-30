package com.songfinder.sbproject.domain.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(APIErrorException.class)
    public ResponseEntity<ErrorResponse> handleAPIErrorException(APIErrorException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode(),ex.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(ex.getStatusCode()));
    }
}
