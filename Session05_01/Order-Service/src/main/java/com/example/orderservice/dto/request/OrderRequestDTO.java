package com.example.orderservice.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderRequestDTO {
    @NotNull(message = "Không được để trống id khách hàng!")
    private Long customerId;
    @NotNull(message = "Không được để trống id sản phẩm!")
    private Long productId;
    @NotNull(message = "Không được để trống số lượng mua!")
    @Min(value = 1, message = "Số lượng không được nhỏ hơn 1")
    private Integer quantity;
}
