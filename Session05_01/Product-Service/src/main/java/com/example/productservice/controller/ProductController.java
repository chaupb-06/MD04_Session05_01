package com.example.productservice.controller;

import com.example.productservice.dto.request.ProductRequestDTO;
import com.example.productservice.dto.response.ApiResponse;
import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<ApiResponse<?>> createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Tạo sản phẩm mới thành công!",
                productService.createProduct(productRequestDTO),
                LocalDateTime.now()
        ), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getProduct(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy thông tin sản phẩm thành công!",
                productService.findProductById(id),
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllProducts() {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy danh sách sản phẩm thành công!",
                productService.getAllProducts(),
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
}
