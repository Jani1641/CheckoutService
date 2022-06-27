package com.EcommWeb.CheckoutService.exceptionHandlers;

import com.EcommWeb.CheckoutService.Exceptions.ResourceNotFoundException;
import com.EcommWeb.CheckoutService.exceptionResponses.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException (ResourceNotFoundException ex){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ExceptionResponse(status,ex.getMessage()),status);
    }


}
