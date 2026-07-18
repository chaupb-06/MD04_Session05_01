package com.example.customerservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerRequestDTO {
    @NotBlank(message = "Không được để trống tên khách hàng")
    private String fullName;
    @NotBlank(message = "Không được để trống email")
    @Email(message = "Email sai định dạng")
    private String email;
    @NotBlank(message = "Không được để trống mật khẩu")
    private String password;
}
