package com.productCatalog.productCatalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = ProductException.class)
    public ResponseEntity<Object> customerNotFound(ProductException exception){
        Error err=new Error(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

}
