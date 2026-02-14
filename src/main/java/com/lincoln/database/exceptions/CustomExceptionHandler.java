package com.lincoln.database.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CreateRecordException.class)
    public ResponseEntity<Object> createRecordExceptionResponse(CreateRecordException e) {

        return ResponseEntity.internalServerError().body(Map.of("message", e.getMessage(), "id", e.getId()));

    }
}
