package com.keanghor.java.miniproject.Exception;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
//        get field name and message error form exception
        for (var fieldError : exception.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Validation failed."
        );
        problemDetail.setType(URI.create("http://localhost:8080/api/v1/users/badrequest"));
        problemDetail.setTitle("Bad Request");
//        set errors into problemDetail
        problemDetail.setProperty("errors", errors);
        return problemDetail;
    }
    @ExceptionHandler(HandlerMethodValidationException.class)
    public ProblemDetail methodValidationExceptionHandler(HandlerMethodValidationException exception) {
        Map<String, String> errors = new HashMap<>();
//      get parameter name and error message from exception
        for (var parameterError : exception.getAllValidationResults()) {
            final String parameterName = parameterError.getMethodParameter().getParameterName();
            for (var error : parameterError.getResolvableErrors()) {
                errors.put(parameterName, error.getDefaultMessage());
            }
        }

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Validation failed."
        );
        problemDetail.setType(URI.create("http://localhost:8080/api/v1/users/badrequest"));
        problemDetail.setTitle("Bad Request");
//      set errors into problemDetail
        problemDetail.setProperty("errors", errors);
        return problemDetail;
    }
    @ExceptionHandler(NotFoundException.class)
    ProblemDetail handlerNotFoundException(NotFoundException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    ProblemDetail handlerBadRequestException(BadRequestException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,e.getMessage());
    }
}