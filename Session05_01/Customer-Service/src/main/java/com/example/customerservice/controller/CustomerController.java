package com.example.customerservice.controller;

import com.example.customerservice.dto.request.CustomerRequestDTO;
import com.example.customerservice.dto.request.LoginCustomerRequestDTO;
import com.example.customerservice.dto.response.ApiResponse;
import com.example.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> registerCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO){
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Tạo mới khách hàng thành công!",
                customerService.registerCustomer(customerRequestDTO),
                LocalDateTime.now()
        ), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy thông tin khách hàng thành công!",
                customerService.findCustomerById(id),
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
    @PutMapping("/login")
    public ResponseEntity<ApiResponse<?>> login(@Valid @RequestBody LoginCustomerRequestDTO loginCustomerRequestDTO){
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Đăng nhập thành công!",
                customerService.loginCustomer(loginCustomerRequestDTO),
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
}
