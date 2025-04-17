package com.example.btl_mad_backend.service.exercise;

import com.example.btl_mad_backend.dto.exercise.ExerciseDTO;
import com.example.btl_mad_backend.entity.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
    public List<ExerciseDTO> getAllExercises();
    public ExerciseDTO getExerciseById(long id);
    public List<ExerciseDTO> getExerciseByTeacher(long teacherId);
    public List<ExerciseDTO> searchExercise(String title, int grade, int exerciseType);
    public ExerciseDTO addExercise(ExerciseDTO exerciseDto);
    public ExerciseDTO updateExercise(ExerciseDTO exerciseDto);
    public void deleteExercise(long id);
}
