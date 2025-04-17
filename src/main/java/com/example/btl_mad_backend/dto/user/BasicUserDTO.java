package com.example.btl_mad_backend.dto.user;

import com.example.btl_mad_backend.entity.Role;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasicUserDTO {
    private Long id;
    private String email;
    private String name;
}
