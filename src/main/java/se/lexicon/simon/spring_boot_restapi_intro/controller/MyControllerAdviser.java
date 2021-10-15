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


    private MyExceptionResponse build(HttpStatus httpStatus, String ex, WebRequest request) {
        return new MyExceptionResponse(
                LocalDateTime.now(),
                httpStatus.value(),
                httpStatus.name(),
                ex,
                request.getDescription(false)
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MyExceptionResponse handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request){
        return build(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MyExceptionResponse handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
        return build(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }





}
