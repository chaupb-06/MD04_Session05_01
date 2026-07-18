package com.example.productservice.advice;

import com.example.productservice.dto.response.ApiResponseError;
import com.example.productservice.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseError<?>> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new ApiResponseError<>(
                false,
                "Dữ liệu không tồn tại",
                e.getMessage(),
                LocalDateTime.now()
        ), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseError<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(new ApiResponseError<>(
                false,
                "Dữ liệu đầu vào không hợp lệ!",
                errors,
                LocalDateTime.now()
        ), HttpStatus.BAD_REQUEST);
    }
}
