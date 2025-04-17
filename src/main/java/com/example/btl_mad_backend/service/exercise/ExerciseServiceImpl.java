package com.example.btl_mad_backend.service.exercise;

import com.example.btl_mad_backend.dto.exercise.ExerciseDTO;
import com.example.btl_mad_backend.entity.Exercise;
import com.example.btl_mad_backend.entity.User;
import com.example.btl_mad_backend.exception.AppException;
import com.example.btl_mad_backend.exception.ErrorCode;
import com.example.btl_mad_backend.mapper.ExerciseMapper;
import com.example.btl_mad_backend.mapper.UserMapper;
import com.example.btl_mad_backend.repository.ExerciseRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final HttpSession session;
    private final ExerciseMapper exerciseMapper;
    private final UserMapper userMapper;

    @Override
    public List<ExerciseDTO> getAllExercises() {
        System.out.println(exerciseRepository.findAll());
        System.out.println(exerciseRepository.findAll().stream().map(exerciseMapper::toExerciseDTO).toList());
        return exerciseRepository.findAll().stream().map(exerciseMapper::toExerciseDTO).toList();
    }

    @Override
    public ExerciseDTO getExerciseById(long id) {
        Exercise exercise = exerciseRepository.findById(id).orElseThrow();
        return exerciseMapper.toExerciseDTO(exercise);
    }

    @Override
    public List<ExerciseDTO> getExerciseByTeacher(long teacherId) {
        return exerciseRepository.findByUserId(teacherId).stream().map(exerciseMapper::toExerciseDTO).collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDTO> searchExercise(String title, int grade, int exerciseType) {
        if ((title == null || title.isEmpty()) && grade == 0 && exerciseType == 0) {
            return exerciseRepository.findAll().stream().map(exerciseMapper::toExerciseDTO).collect(Collectors.toList());
        }

        if (title != null && !title.isEmpty()) {
            return exerciseRepository.findByTitleIsContaining(title).stream().map(exerciseMapper::toExerciseDTO).collect(Collectors.toList());
        }

        if (grade != 0 && exerciseType == 0) {
            return exerciseRepository.findByGrade(grade).stream().map(exerciseMapper::toExerciseDTO).collect(Collectors.toList());
        }

        if (grade == 0) {
            return exerciseRepository.findByExerciseType(exerciseType).stream().map(exerciseMapper::toExerciseDTO).collect(Collectors.toList());
        }

        return exerciseRepository.findByGradeAndExerciseType(grade, exerciseType).stream().map(exerciseMapper::toExerciseDTO).collect(Collectors.toList());
    }


    @Override
    public ExerciseDTO addExercise(ExerciseDTO exerciseDto) {
        Exercise exercise = new Exercise();
        exercise.setTitle(exerciseDto.getTitle());
        exercise.setExerciseType(exerciseDto.getExerciseType());
        exercise.setGrade(exerciseDto.getGrade());
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }
        exercise.setUser(user);
        Exercise savedExercise = exerciseRepository.save(exercise);
        return new ExerciseDTO(savedExercise.getId(), savedExercise.getExerciseType(), savedExercise.getTitle(), savedExercise.getGrade(), userMapper.userToBasicUserDTO(
                savedExercise.getUser()));
    }

    @Override
    public ExerciseDTO updateExercise(ExerciseDTO exerciseDto) {
        Exercise exercise = exerciseRepository.findById(exerciseDto.getId()).get();
        exercise.setTitle(exerciseDto.getTitle());
        exercise.setExerciseType(exerciseDto.getExerciseType());
        exercise.setGrade(exerciseDto.getGrade());
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }
        Exercise savedExercise = exerciseRepository.save(exercise);
        return new ExerciseDTO(savedExercise.getId(), savedExercise.getExerciseType(), savedExercise.getTitle(), savedExercise.getGrade(), userMapper.userToBasicUserDTO(
                savedExercise.getUser()));
    }

    @Override
    public void deleteExercise(long id) {
        Exercise exercise = exerciseRepository.findById(id).get();
        exerciseRepository.delete(exercise);
    }
}
