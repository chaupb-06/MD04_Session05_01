package com.example.customerservice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiResponseError <T>{
    LocalDateTime timestamp;
    HttpStatus status;
    T error;
    String message;
}
