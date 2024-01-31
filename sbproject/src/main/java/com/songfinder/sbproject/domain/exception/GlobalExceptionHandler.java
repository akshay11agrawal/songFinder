package com.songfinder.sbproject.domain.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(APIErrorException.class)
    public ResponseEntity<ErrorResponse> handleAPIErrorException(APIErrorException ex) {
        String error = "An error occurred. Please try again later.";
        return new ResponseEntity<>(ErrorResponse.builder().message(error)
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
