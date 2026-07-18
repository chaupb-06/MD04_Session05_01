package com.example.orderservice.service.Impl;

import com.example.orderservice.dto.response.ProductResponseDTO;
import com.example.orderservice.exception.InventoryServiceException;
import com.example.orderservice.service.InventoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;
    private final RestClient restClient;

    @Override
    public ProductResponseDTO getProduct(Long id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCT-SERVICE");
        if (instances == null || instances.isEmpty()) {
            throw new InventoryServiceException("Service Unavailable");
        }
        ServiceInstance serviceInstance = instances.get(0);
        String baseUrl = serviceInstance.getUri().toString();
        String targetUrl = baseUrl + "/api/v1/products/" + id;
        try {
            return restClient.get()
                    .uri(targetUrl)
                    .retrieve()
                    .body(ProductResponseDTO.class);
        }
        catch (Exception ex) {
            throw new InventoryServiceException("Hệ thống đang quá tải, yêu cầu của bạn đã được ghi nhận nhưng chưa thể hoàn tất kiểm tra kho. Vui lòng quay lại sau 1 phút.");
        }
    }
}
