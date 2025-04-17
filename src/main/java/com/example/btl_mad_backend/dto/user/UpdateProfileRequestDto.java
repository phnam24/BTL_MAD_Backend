package com.example.btl_mad_backend.dto.user;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class UpdateProfileRequestDto {
    @Size(min = 2, max = 100, message = "Tên phải có độ dài từ 2 đến 100 ký tự!")
    private String name;
}
