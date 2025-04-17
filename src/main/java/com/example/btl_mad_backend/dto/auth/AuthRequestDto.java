package com.example.btl_mad_backend.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthRequestDto {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
