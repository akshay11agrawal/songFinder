package com.songfinder.sbproject.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class APIErrorException extends RuntimeException{
    private int statusCode;
    private String errorMessage;
}
