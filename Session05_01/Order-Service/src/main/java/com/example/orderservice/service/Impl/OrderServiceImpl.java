package com.example.orderservice.service.Impl;

import com.example.orderservice.dto.request.OrderRequestDTO;
import com.example.orderservice.dto.response.OrderResponseDTO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.exception.ResourceNotFoundException;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Double productPrice = 15000.00;
        Double totalAmount = productPrice*orderRequestDTO.getQuantity();
        Order order = Order.builder()
                .customerId(orderRequestDTO.getCustomerId())
                .productId(orderRequestDTO.getProductId())
                .totalAmount(totalAmount)
                .build();
        orderRepository.save(order);
        return OrderResponseDTO.builder()
                .orderId(order.getId())
                .customerId(order.getCustomerId())
                .productId(order.getProductId())
                .orderDate(order.getOrderDate())
                .totalAmount(order.getTotalAmount())
                .build();
    }

    @Override
    public OrderResponseDTO getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));
        return OrderResponseDTO.builder()
                .orderId(order.getId())
                .customerId(order.getCustomerId())
                .productId(order.getProductId())
                .orderDate(order.getOrderDate())
                .totalAmount(order.getTotalAmount())
                .build();
    }
}
