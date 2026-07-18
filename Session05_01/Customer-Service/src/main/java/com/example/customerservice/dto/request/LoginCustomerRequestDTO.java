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
public class LoginCustomerRequestDTO {
    @NotBlank(message = "Không được để trống email!")
    @Email(message = "Không đúng định dạng email!")
    private String email;
    @NotBlank(message = "Không được để trống mật khẩu!")
    private String password;
}
