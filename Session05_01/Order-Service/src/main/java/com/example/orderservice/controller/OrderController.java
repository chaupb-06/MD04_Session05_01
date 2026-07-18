package com.example.orderservice.controller;

import com.example.orderservice.dto.request.OrderRequestDTO;
import com.example.orderservice.dto.response.ApiResponse;
import com.example.orderservice.service.InventoryService;
import com.example.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final InventoryService inventoryService;
    @PostMapping
    public ResponseEntity<ApiResponse<?>> createOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Tạo hóa đơn thành công!",
                orderService.createOrder(orderRequestDTO),
                LocalDateTime.now()
        ), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getOrder(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy thông tin hóa đơn thành công!",
                orderService.getOrder(id),
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ApiResponse<?>> getProduct(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Tìm thấy instance thành công!",
                inventoryService.getProduct(id),
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
}
