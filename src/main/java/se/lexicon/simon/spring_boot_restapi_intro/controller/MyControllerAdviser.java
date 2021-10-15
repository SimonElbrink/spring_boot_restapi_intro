package se.lexicon.simon.spring_boot_restapi_intro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import se.lexicon.simon.spring_boot_restapi_intro.exception.MyExceptionResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MyControllerAdviser {


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MyExceptionResponse> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request){

        MyExceptionResponse response = new MyExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage(),
                request.getDescription(false)
        );

       return ResponseEntity.badRequest().body(response);
    }



}
