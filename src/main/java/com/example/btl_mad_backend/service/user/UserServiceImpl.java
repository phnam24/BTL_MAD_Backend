package com.example.btl_mad_backend.service.user;

import com.example.btl_mad_backend.dto.user.ChangePasswordRequestDto;
import com.example.btl_mad_backend.dto.user.UpdateProfileRequestDto;
import com.example.btl_mad_backend.dto.user.UserProfileResponseDto;
import com.example.btl_mad_backend.entity.Role;
import com.example.btl_mad_backend.entity.Student;
import com.example.btl_mad_backend.entity.User;
import com.example.btl_mad_backend.exception.AppException;
import com.example.btl_mad_backend.exception.ErrorCode;
import com.example.btl_mad_backend.repository.StudentRepository;
import com.example.btl_mad_backend.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final HttpSession session;

    @Override
    public UserProfileResponseDto getUserProfile() {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }
        if (user.getRole().equals(Role.student)) {
            Student student = studentRepository.findById(user.getId())
                    .orElseThrow(() -> new AppException(ErrorCode.UNAUTHORIZED));
            return new UserProfileResponseDto(user.getId(), user.getEmail(), user.getName(), user.getRole(), student.getGrade(), student.getScore());
        }
        return new UserProfileResponseDto(user.getId(), user.getEmail(), user.getName(), user.getRole());
    }

    @Override
    public void changePassword(ChangePasswordRequestDto changePasswordRequestDto) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }
        if (!passwordEncoder.matches(changePasswordRequestDto.getOldPassword(), user.getPasswordHash())) {
            throw new AppException(ErrorCode.WRONG_PASSWORD);
        }
        user.setPasswordHash(passwordEncoder.encode(changePasswordRequestDto.getNewPassword()));
        userRepository.save(user);
    }

    @Override
    public UserProfileResponseDto updateUserProfile(UpdateProfileRequestDto updateProfileRequestDto) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }
        user.setName(updateProfileRequestDto.getName());
        userRepository.save(user);
        return new UserProfileResponseDto(user.getId(), user.getEmail(), user.getName(), user.getRole());
    }
}
