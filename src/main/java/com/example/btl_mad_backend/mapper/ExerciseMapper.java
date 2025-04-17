package com.example.btl_mad_backend.mapper;

import com.example.btl_mad_backend.dto.exercise.ExerciseDTO;
import com.example.btl_mad_backend.dto.user.UserProfileResponseDto;
import com.example.btl_mad_backend.entity.Exercise;
import com.example.btl_mad_backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.Optional;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface ExerciseMapper {
    Exercise toExercise(ExerciseDTO exerciseDTO);
    ExerciseDTO toExerciseDTO(Exercise exercise);
}
