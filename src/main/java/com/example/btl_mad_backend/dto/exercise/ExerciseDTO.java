package com.example.btl_mad_backend.dto.exercise;

import com.example.btl_mad_backend.dto.user.BasicUserDTO;
import com.example.btl_mad_backend.dto.user.UserProfileResponseDto;
import com.example.btl_mad_backend.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDTO {
    private Long id;
    private Integer exerciseType;
    private String title;
    private int grade;
    private BasicUserDTO user;
}
