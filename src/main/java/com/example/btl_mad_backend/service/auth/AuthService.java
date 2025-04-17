package com.example.btl_mad_backend.service.auth;

import com.example.btl_mad_backend.dto.auth.AuthRequestDto;
import com.example.btl_mad_backend.dto.auth.AuthResponseDto;
import com.example.btl_mad_backend.dto.auth.RegisterRequestDto;
import org.springframework.stereotype.Service;

public interface AuthService {
    public AuthResponseDto login(AuthRequestDto authRequestDto);
    public AuthResponseDto register(RegisterRequestDto registerRequestDto);
    public void logout();
}
