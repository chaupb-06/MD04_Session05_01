package com.example.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseError<?>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(new ApiResponseError<>(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                "Dữ liệu không tồn tại!"
        ), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ApiResponseError<?>> handleIncorrectPasswordException(IncorrectPasswordException ex) {
        return new ResponseEntity<>(new ApiResponseError<>(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                "Sai dữ liệu nhập vào!"
        ), HttpStatus.BAD_REQUEST);
    }
}
