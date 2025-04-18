package com.example.btl_mad_backend.dto.auth;

import com.example.btl_mad_backend.entity.Role;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto {
    private String email;
    private String name;
    private Role role;
    private String token;

    public AuthResponseDto(String email, String name, Role role) {
        this.email = email;
        this.name = name;
        this.role = role;
    }
}