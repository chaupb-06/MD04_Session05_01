package com.example.orderservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponseDTO {
    private Long productId;
    private String productName;
    private Double price;
    private Double quantity;
}
