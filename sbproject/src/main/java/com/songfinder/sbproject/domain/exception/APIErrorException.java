package com.songfinder.sbproject.domain.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class APIErrorException extends RuntimeException{
    private int statusCode;
    private String errorMessage;
}
