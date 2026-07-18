package com.example.productservice.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequestDTO {
    @NotBlank(message = "Không được để trống tên sản phẩm!")
    private String name;
    @NotNull(message = "Không được để trống giá tiền!")
    @Min(value = 1, message = "Giá tiền luôn lớn hơn 0")
    private Double price;
    @NotNull(message = "Không được để trống số lượng tồn kho!")
    @Min(value = 0, message = "Số lượng tồn kho không được âm!")
    private Integer stockQuantity;
}
