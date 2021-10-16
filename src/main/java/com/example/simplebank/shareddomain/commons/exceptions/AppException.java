package com.example.simplebank.shareddomain.commons.exceptions;

import lombok.Getter;

@Getter
public class AppException extends Exception{

    private String field;

    public AppException(String field, String message) {
        super(message);
        this.field = field;
    }

}
