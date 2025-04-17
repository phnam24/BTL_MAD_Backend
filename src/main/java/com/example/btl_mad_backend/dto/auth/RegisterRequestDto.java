package com.example.btl_mad_backend.dto.auth;

import com.example.btl_mad_backend.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private Role role;  // "student" hoặc "teacher"

    private String grade; // Chỉ có nếu role là "student"
}
