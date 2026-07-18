package com.example.customerservice.service;

import com.example.customerservice.dto.request.CustomerRequestDTO;
import com.example.customerservice.dto.request.LoginCustomerRequestDTO;
import com.example.customerservice.dto.response.CustomerResponseDTO;

public interface CustomerService {
    CustomerResponseDTO registerCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO findCustomerById(Long id);
    CustomerResponseDTO loginCustomer(LoginCustomerRequestDTO loginCustomerRequestDTO);
}
