package com.example.orderservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderResponseDTO {
    private Long orderId;
    private Long customerId;
    private Long productId;
    private LocalDateTime orderDate;
    private Double totalAmount;
}
