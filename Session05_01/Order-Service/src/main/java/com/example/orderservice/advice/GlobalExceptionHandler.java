package com.example.orderservice.advice;

import com.example.orderservice.dto.response.ApiResponseError;
import com.example.orderservice.exception.InventoryServiceException;
import com.example.orderservice.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseError<?>> handleResourceNotFoundException(ResourceNotFoundException ex){
        return new ResponseEntity<>(new ApiResponseError<>(
                false,
                "Dữ liệu không tồn tại!",
                ex.getMessage(),
                LocalDateTime.now()
        ), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseError<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String filedName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(filedName, errorMessage);
        });
        return new ResponseEntity<>(new ApiResponseError<>(
                false,
                "Sai dữ liệu đầu vào!",
                errors,
                LocalDateTime.now()
        ), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InventoryServiceException.class)
    public ResponseEntity<ApiResponseError<?>> handleInstanceNotFoundException(InventoryServiceException ex){
        return new ResponseEntity<>(new ApiResponseError<>(
                false,
                "Lỗi server!",
                ex.getMessage(),
                LocalDateTime.now()
        ), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
