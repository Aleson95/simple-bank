package com.example.simplebank.shareddomain.commons.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppResponse<T> {

    private String message;
    private List<ErrorWrapper> errors;
    private T data;

    public AppResponse(String message, String field, String error, T data) {
        this.message = message;
        this.errors = List.of(ErrorWrapper.builder().field(field).message(error).build());;
        this.data = data;
    }

}
