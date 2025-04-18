package com.example.btl_mad_backend.service.auth;

import com.example.btl_mad_backend.dto.auth.AuthRequestDto;
import com.example.btl_mad_backend.dto.auth.AuthResponseDto;
import com.example.btl_mad_backend.dto.auth.RegisterRequestDto;
import com.example.btl_mad_backend.entity.Role;
import com.example.btl_mad_backend.entity.Student;
import com.example.btl_mad_backend.entity.User;
import com.example.btl_mad_backend.exception.AppException;
import com.example.btl_mad_backend.exception.ErrorCode;
import com.example.btl_mad_backend.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final HttpSession session;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponseDto login(AuthRequestDto authRequestDto, Role role) {
        User user = userRepository.findByEmail(authRequestDto.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        if (!passwordEncoder.matches(authRequestDto.getPassword(), user.getPasswordHash())) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }

        if (!user.getRole().equals(role)) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }

        session.setAttribute("user", user);
        return new AuthResponseDto(user.getEmail(), user.getName(), user.getRole());
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto registerRequestDto) {
        if (userRepository.existsByEmail(registerRequestDto.getEmail())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = new User();
        user.setEmail(registerRequestDto.getEmail());
        user.setName(registerRequestDto.getName());
        user.setPasswordHash(passwordEncoder.encode(registerRequestDto.getPassword()));
        user.setRole(registerRequestDto.getRole());
        if (user.getRole() == null) {
            throw new AppException(ErrorCode.MISSING_POSITION);
        }
        if (user.getRole().equals(Role.student)) {
            if (registerRequestDto.getGrade()==0) {
                throw new AppException(ErrorCode.MISSING_GRADE);
            }
            Student student = new Student(user, registerRequestDto.getGrade());
            user.setStudent(student);
        }

        try {
            session.setAttribute("user", user);
            userRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        return new AuthResponseDto(user.getEmail(), user.getName(), user.getRole());
    }

    @Override
    public void logout() {
        session.invalidate();
    }
}
