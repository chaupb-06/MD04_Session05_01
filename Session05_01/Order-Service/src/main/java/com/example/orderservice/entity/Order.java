package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @Column(name = "customer_id", nullable = false)
    private Long customerId;
    @Column(name = "product_id", nullable = false, unique = true)
    private Long productId;
    @Column(name = "order_date", nullable = false)
    @Builder.Default
    private LocalDateTime orderDate = LocalDateTime.now();
    @Column(name = "total_amount", nullable = false, columnDefinition = "numeric(10,2) default 0.00")
    @Builder.Default
    private Double totalAmount = 0.00;
}
