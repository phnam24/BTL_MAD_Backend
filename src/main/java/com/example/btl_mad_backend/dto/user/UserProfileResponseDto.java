package com.example.btl_mad_backend.dto.user;

import com.example.btl_mad_backend.entity.Role;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponseDto {
    private Long id;
    private String email;
    private String name;
    private Role role;
    private int grade;
    private Integer score;

    public UserProfileResponseDto(Long id, String email, String name, Role role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.role = role;
    }
}
