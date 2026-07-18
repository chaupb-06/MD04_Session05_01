package com.example.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(nullable = false, columnDefinition = "numeric(10,2) default 0.00")
    @Builder.Default
    private Double price = 0.00;
    @Column(name = "stock_quantity", nullable = false, columnDefinition = "int default 0")
    @Builder.Default
    private Integer stockQuantity = 0;
}
