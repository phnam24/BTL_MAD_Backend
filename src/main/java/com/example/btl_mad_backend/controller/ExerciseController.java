package com.example.btl_mad_backend.controller;

import com.example.btl_mad_backend.dto.ApiResponse;
import com.example.btl_mad_backend.dto.exercise.ExerciseDTO;
import com.example.btl_mad_backend.dto.user.UserProfileResponseDto;
import com.example.btl_mad_backend.entity.Exercise;
import com.example.btl_mad_backend.service.exercise.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/exercise")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping("/")
    public ApiResponse<List<ExerciseDTO>> getAllExercises() {
        return ApiResponse.<List<ExerciseDTO>>builder()
                .result(exerciseService.getAllExercises())
                .build();
    }

    @GetMapping("/{exercise_id}")
    public ApiResponse<ExerciseDTO> getExerciseById(@PathVariable long exercise_id) {
        return ApiResponse.<ExerciseDTO>builder()
                .result(exerciseService.getExerciseById(exercise_id))
                .build();
    }

    @GetMapping("/search")
    public ApiResponse<List<ExerciseDTO>> searchExercisesByGradeAndType(
            @RequestParam(value = "title", defaultValue = "") String title,
            @RequestParam(value = "grade", defaultValue = "0") int grade,
            @RequestParam(value = "exercise-type", defaultValue = "0") int exerciseType) {
        return ApiResponse.<List<ExerciseDTO>>builder()
                .result(exerciseService.searchExercise(title, grade, exerciseType))
                .build();
    }


    @PostMapping("/addExercise")
    public ApiResponse<ExerciseDTO> addExercise(@RequestBody ExerciseDTO exerciseDto) {
        return ApiResponse.<ExerciseDTO>builder()
                .result(exerciseService.addExercise(exerciseDto))
                .build();
    }

    @PutMapping("/updateExercise")
    public ApiResponse<ExerciseDTO> updateExercise(@RequestBody ExerciseDTO exerciseDto) {
        return ApiResponse.<ExerciseDTO>builder()
                .result(exerciseService.updateExercise(exerciseDto))
                .build();
    }

    @DeleteMapping("/deleteExercise/{exercise_id}")
    public ApiResponse<String> deleteExercise(@PathVariable Long exercise_id) {
        exerciseService.deleteExercise(exercise_id);

        return ApiResponse.<String>builder()
                .result("Exercise deleted")
                .build();
    }
}
