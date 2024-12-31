package bj.uac.ine.webdev.controllers;

import bj.uac.ine.webdev.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class MainRestControllerAdvice {
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Map<String, String>> handleHttpClientErrorException(
            HttpClientErrorException exception
    ) {
        Map<String, String> response = new HashMap<>();
        response.put("error", exception.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ) {
        Map<String, String> response = new HashMap<>();

        List<ObjectError> errors = exception.getBindingResult()
                .getAllErrors();

        for (ObjectError error : errors) {
            FieldError fieldError = (FieldError) error;
            response.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                .body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleEntityNotFoundException(
            EntityNotFoundException exception
    ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        Map.of("error", exception.getMessage())
                );
    }
}
