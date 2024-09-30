package com.imsjt.gestaomatriculas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class InvalidRequestException extends HttpClientErrorException {
    public InvalidRequestException(String text) {
        super(HttpStatus.BAD_REQUEST, text);
    }

}
