package se.lexicon.simon.spring_boot_restapi_intro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import se.lexicon.simon.spring_boot_restapi_intro.exception.MyExceptionResponse;
import se.lexicon.simon.spring_boot_restapi_intro.exception.ResourceNotFoundException;
import se.lexicon.simon.spring_boot_restapi_intro.exception.ValidationErrorResponse;
import se.lexicon.simon.spring_boot_restapi_intro.exception.Violation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request){
        List<Violation> violations = new ArrayList<>();

        for (FieldError error: ex.getBindingResult().getFieldErrors()) {
            violations.add(new Violation(error.getField(), error.getDefaultMessage()));
        }
        return new ValidationErrorResponse(build(HttpStatus.BAD_REQUEST, "One Or Several Validations Failed", request), violations );
    }





}
