package com.example.orderservice.service;

import com.example.orderservice.dto.response.ProductResponseDTO;

public interface InventoryService {
    ProductResponseDTO getProduct(Long id);
}
