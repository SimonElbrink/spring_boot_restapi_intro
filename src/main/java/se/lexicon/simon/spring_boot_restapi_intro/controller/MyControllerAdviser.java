package se.lexicon.simon.spring_boot_restapi_intro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import se.lexicon.simon.spring_boot_restapi_intro.exception.MyExceptionResponse;
import se.lexicon.simon.spring_boot_restapi_intro.exception.ResourceNotFoundException;

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


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MyExceptionResponse handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){

        return new MyExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage(),
                request.getDescription(false)
        );

    }





}
