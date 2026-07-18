package com.example.productservice.service.Impl;

import com.example.productservice.dto.request.ProductRequestDTO;
import com.example.productservice.dto.response.ProductResponseDTO;
import com.example.productservice.entity.Product;
import com.example.productservice.exception.ResourceNotFoundException;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = Product.builder()
                .name(productRequestDTO.getName())
                .price(productRequestDTO.getPrice())
                .stockQuantity(productRequestDTO.getStockQuantity())
                .build();
        productRepository.save(product);
        return ProductResponseDTO.builder()
                .productId(product.getId())
                .name(productRequestDTO.getName())
                .price(productRequestDTO.getPrice())
                .stockQuantity(productRequestDTO.getStockQuantity())
                .build();
    }

    @Override
    public ProductResponseDTO findProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return ProductResponseDTO.builder()
                .productId(productId)
                .name(product.getName())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .build();
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> ProductResponseDTO.builder()
                        .productId(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .stockQuantity(product.getStockQuantity())
                        .build()
                ).toList();
    }
}
