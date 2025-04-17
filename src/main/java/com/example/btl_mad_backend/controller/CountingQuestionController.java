package com.example.btl_mad_backend.controller;

import com.example.btl_mad_backend.dto.ApiResponse;
import com.example.btl_mad_backend.dto.question.CountingQuestionCreateDTO;
import com.example.btl_mad_backend.dto.question.CountingQuestionDTO;
import com.example.btl_mad_backend.service.question.CountingQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/counting-questions")
@RequiredArgsConstructor
public class CountingQuestionController {

    private final CountingQuestionService questionService;

    @GetMapping("/exercise/{exerciseId}")
    public ResponseEntity<ApiResponse<List<CountingQuestionDTO>>> getByExerciseId(@PathVariable Long exerciseId) {
        List<CountingQuestionDTO> questions = questionService.getByExerciseId(exerciseId);
        return ResponseEntity.ok(
                ApiResponse.<List<CountingQuestionDTO>>builder()
                        .code(200)
                        .message("Get counting questions successfully")
                        .result(questions)
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CountingQuestionDTO>> create(@RequestBody CountingQuestionCreateDTO dto) {
        CountingQuestionDTO created = questionService.create(dto);
        return ResponseEntity.ok(
                ApiResponse.<CountingQuestionDTO>builder()
                        .code(200)
                        .message("Created counting question successfully")
                        .result(created)
                        .build()
        );
    }
}
