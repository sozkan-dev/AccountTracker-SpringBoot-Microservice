package com.sozkandev.customer.exception;

import com.sozkandev.customer.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerCustomException.class)
    public ResponseEntity<com.sozkandev.customer.model.ErrorResponse> handleCustomException(CustomerCustomException exception) {

        return new ResponseEntity<>(new ErrorResponse().builder()
                                                       .errorMessage(exception.getMessage())
                                                       .errorCode(exception.getErrorCode())
                                                       .build(), HttpStatus.NOT_FOUND);
    }


}