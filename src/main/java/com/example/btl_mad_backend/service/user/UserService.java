package com.example.btl_mad_backend.service.user;

import com.example.btl_mad_backend.dto.user.ChangePasswordRequestDto;
import com.example.btl_mad_backend.dto.user.UpdateProfileRequestDto;
import com.example.btl_mad_backend.dto.user.UserProfileResponseDto;

public interface UserService {
    public UserProfileResponseDto getUserProfile();
    public void changePassword(ChangePasswordRequestDto changePasswordRequestDto);
    public UserProfileResponseDto updateUserProfile(UpdateProfileRequestDto updateProfileRequestDto);
}
