package com.songfinder.sbproject.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(APIErrorException.class)
    public ResponseEntity<String> handleAPIErrorException(APIErrorException ex) {
        // log the exception
        System.out.println("An exception occurred: " + ex.getMessage());

        String error = "An error occurred. Please try again later.";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
