package com.example.simplebank.shareddomain.commons.utils;

import com.example.simplebank.shareddomain.commons.messages.AppResponse;
import com.example.simplebank.shareddomain.commons.messages.ErrorWrapper;

import java.util.Collections;

public class AppUtils {

    public static AppResponse successResponse(String message, Object data) {
        return AppResponse.builder()
                .message(message)
                .data(data)
                .build();
    }

    public static AppResponse errorResponse(String message, String field, String errorMessage) {
        return AppResponse.builder()
                .message(message)
                .errors(Collections.singletonList(ErrorWrapper.builder().field(field).message(errorMessage).build()))
                .build();
    }

}
