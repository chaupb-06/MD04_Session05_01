package com.example.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @Column(length = 200, name = "full_name", nullable = false)
    private String fullName;
    @Column(length = 200, nullable = false, unique = true)
    private String email;
    @Column(length = 200, nullable = false)
    private String password;
}
