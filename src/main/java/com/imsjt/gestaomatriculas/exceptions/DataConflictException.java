package com.imsjt.gestaomatriculas.exceptions;

import org.springframework.http.HttpStatus;

public class DataConflictException extends RuntimeException {
    public DataConflictException(String text) {
        super(text);
    }
}
