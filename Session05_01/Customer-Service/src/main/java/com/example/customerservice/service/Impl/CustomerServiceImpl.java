package com.example.customerservice.service.Impl;

import com.example.customerservice.dto.request.CustomerRequestDTO;
import com.example.customerservice.dto.request.LoginCustomerRequestDTO;
import com.example.customerservice.dto.response.CustomerResponseDTO;
import com.example.customerservice.entity.Customer;
import com.example.customerservice.exception.IncorrectPasswordException;
import com.example.customerservice.exception.ResourceNotFoundException;
import com.example.customerservice.repository.CustomerRepository;
import com.example.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CustomerResponseDTO registerCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = Customer.builder()
                .fullName(customerRequestDTO.getFullName())
                .email(customerRequestDTO.getEmail())
                .password(passwordEncoder.encode(customerRequestDTO.getPassword()))
                .build();
        customerRepository.save(customer);
        return CustomerResponseDTO.builder()
                .customerId(customer.getId())
                .fullName(customer.getFullName())
                .email(customer.getEmail())
                .build();
    }

    @Override
    public CustomerResponseDTO findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id: " + id + " not found"));
        return CustomerResponseDTO.builder()
                .customerId(customer.getId())
                .fullName(customer.getFullName())
                .email(customer.getEmail())
                .build();
    }

    @Override
    public CustomerResponseDTO loginCustomer(LoginCustomerRequestDTO loginCustomerRequestDTO) {
        Customer customer = customerRepository.findCustomerByEmail(loginCustomerRequestDTO.getEmail())
                .orElseThrow(() -> new IncorrectPasswordException("email or password incorrect"));
        if (!passwordEncoder.matches(loginCustomerRequestDTO.getPassword(), customer.getPassword())) {
            throw new IncorrectPasswordException("email or password incorrect");
        }
        return CustomerResponseDTO.builder()
                .customerId(customer.getId())
                .fullName(customer.getFullName())
                .email(customer.getEmail())
                .build();
    }
}
