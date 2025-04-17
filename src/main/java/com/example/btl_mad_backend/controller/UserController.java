package com.example.btl_mad_backend.controller;

import com.example.btl_mad_backend.dto.ApiResponse;
import com.example.btl_mad_backend.dto.user.ChangePasswordRequestDto;
import com.example.btl_mad_backend.dto.user.UpdateProfileRequestDto;
import com.example.btl_mad_backend.dto.user.UserProfileResponseDto;
import com.example.btl_mad_backend.entity.User;
import com.example.btl_mad_backend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/profile")
    public ApiResponse<UserProfileResponseDto> getUserProfile() {
        return ApiResponse.<UserProfileResponseDto>builder()
                .result(userService.getUserProfile())
                .build();
    }

    @PutMapping("/update-profile")
    public ApiResponse<UserProfileResponseDto> updateUserProfile(@RequestBody UpdateProfileRequestDto updateProfileRequestDto) {
        return ApiResponse.<UserProfileResponseDto>builder()
                .result(userService.updateUserProfile(updateProfileRequestDto))
                .build();
    }

    @PutMapping("/change-password")
    public ApiResponse<String> changePassword(@RequestBody ChangePasswordRequestDto changePasswordRequestDto) {
        userService.changePassword(changePasswordRequestDto);
        return ApiResponse.<String>builder()
                .result("Đổi mật khẩu thành công!")
                .build();
    }
}
