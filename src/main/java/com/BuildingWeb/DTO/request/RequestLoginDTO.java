package com.BuildingWeb.DTO.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestLoginDTO {
    @NotBlank(message = "Tên đăng nhập không được để trống")
    private String username;
    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;
}
