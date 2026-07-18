package com.example.customerservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerResponseDTO {
    private Long customerId;
    private String fullName;
    private String email;
}
