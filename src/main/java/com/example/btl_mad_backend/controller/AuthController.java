package com.example.btl_mad_backend.controller;

import com.example.btl_mad_backend.dto.ApiResponse;
import com.example.btl_mad_backend.dto.auth.AuthRequestDto;
import com.example.btl_mad_backend.dto.auth.AuthResponseDto;
import com.example.btl_mad_backend.dto.auth.RegisterRequestDto;
import com.example.btl_mad_backend.entity.Role;
import com.example.btl_mad_backend.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    private ApiResponse<AuthResponseDto> login(@RequestBody @Valid AuthRequestDto authRequestDto, @RequestParam Role role) {
        return ApiResponse.<AuthResponseDto>builder()
                .result(authService.login(authRequestDto, role))
                .build();
    }

    @PostMapping("/register")
    private ApiResponse<AuthResponseDto> register(@RequestBody @Valid RegisterRequestDto registerRequestDto) {
        return ApiResponse.<AuthResponseDto>builder()
                .result(authService.register(registerRequestDto))
                .build();
    }

    @PostMapping("/logout")
    private ApiResponse<String> logout() {
        authService.logout();
        return ApiResponse.<String>builder()
                .result("Đăng xuất thành công!")
                .build();
    }
}
