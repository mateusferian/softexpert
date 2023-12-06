package br.com.mateusferian.softexpert.exceptions;

import  br.com.mateusferian.softexpert.exceptions.models.ErrorObject;
import  br.com.mateusferian.softexpert.exceptions.models.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorObject> errors = getErrors(ex);
        ErrorResponse errorResponse = getErrorResponse( status, errors);
        log.error("data entry error: {}", errorResponse);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorResponse getErrorResponse( HttpStatus status, List<ErrorObject> errors) {
        return new ErrorResponse(
                Instant.now().toEpochMilli(),
                status.value(),
                status.getReasonPhrase(),
                "request has invalid fields", errors);
    }

    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }

    @ResponseBody
    @ExceptionHandler(OrderException.class)
    ResponseEntity<ErrorResponse> handlerOrderException(OrderException ex){
        return  ResponseEntity.status(ex.getError().getStatusCode())
                .body((new ErrorResponse(
                        Instant.now().toEpochMilli(),
                        ex.getError().getStatusCode(),
                        ex.getError().getCode(),
                        ex.getMessage(), new ArrayList<>())));
    }

    @ResponseBody
    @ExceptionHandler(FoodException.class)
    ResponseEntity<ErrorResponse> handlerFoodException(FoodException ex){
        return  ResponseEntity.status(ex.getError().getStatusCode())
                .body((new ErrorResponse(
                        Instant.now().toEpochMilli(),
                        ex.getError().getStatusCode(),
                        ex.getError().getCode(),
                        ex.getMessage(), new ArrayList<>())));
    }

    @ResponseBody
    @ExceptionHandler(UserException.class)
    ResponseEntity<ErrorResponse> handlerUserException(UserException ex){
        return  ResponseEntity.status(ex.getError().getStatusCode())
                .body((new ErrorResponse(
                        Instant.now().toEpochMilli(),
                        ex.getError().getStatusCode(),
                        ex.getError().getCode(),
                        ex.getMessage(), new ArrayList<>())));
    }
}
