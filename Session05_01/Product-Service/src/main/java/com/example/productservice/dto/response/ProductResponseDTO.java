package com.example.productservice.dto.response;

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
    private String name;
    private Double price;
    private Integer stockQuantity;
}
