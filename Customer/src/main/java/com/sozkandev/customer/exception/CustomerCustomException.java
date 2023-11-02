package com.sozkandev.customer.exception;

import lombok.Data;

@Data
public class CustomerCustomException extends RuntimeException{

    private String errorCode;

    public CustomerCustomException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}