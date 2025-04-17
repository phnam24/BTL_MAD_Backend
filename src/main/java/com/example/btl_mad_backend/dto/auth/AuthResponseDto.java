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
}