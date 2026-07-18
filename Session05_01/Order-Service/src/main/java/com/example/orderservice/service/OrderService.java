package com.example.orderservice.service;

import com.example.orderservice.dto.request.OrderRequestDTO;
import com.example.orderservice.dto.response.OrderResponseDTO;

public interface OrderService {
    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);
    OrderResponseDTO getOrder(Long id);
}
