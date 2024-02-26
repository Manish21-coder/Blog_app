package com.blog2.blog_app.exception;

import com.blog2.blog_app.payload.ErroDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroDetails> handleResourceNotFoundException(
       ResourceNotFoundException e,
        WebRequest webRequest
    ){

        ErroDetails erroDetails = new ErroDetails(e.getMessage(),new Date(),webRequest.getDescription(true));

        return new ResponseEntity<>(erroDetails, HttpStatus.INTERNAL_SERVER_ERROR);

      }
}
