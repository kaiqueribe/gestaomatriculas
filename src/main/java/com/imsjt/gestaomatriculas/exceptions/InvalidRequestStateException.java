package com.imsjt.gestaomatriculas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class InvalidRequestStateException extends HttpClientErrorException {
    public InvalidRequestStateException(String text) {
        super(HttpStatus.CONFLICT, text);
    }
}
