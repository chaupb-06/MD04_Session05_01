package com.example.productservice.service;

import com.example.productservice.dto.request.ProductRequestDTO;
import com.example.productservice.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO findProductById(Long productId);
    List<ProductResponseDTO> getAllProducts();
}
