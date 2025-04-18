package com.example.btl_mad_backend.controller;

import com.example.btl_mad_backend.dto.ApiResponse;
import com.example.btl_mad_backend.dto.question.MultipleChoiceQuestionDTO;
import com.example.btl_mad_backend.service.question.MultipleChoiceQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/multiple-choice-questions")
@RequiredArgsConstructor
public class MultipleChoiceQuestionController {

    private final MultipleChoiceQuestionService service;

    @GetMapping("/exercise/{exerciseId}")
    public ApiResponse<List<MultipleChoiceQuestionDTO>> getByExercise(@PathVariable Long exerciseId) {
        List<MultipleChoiceQuestionDTO> questions = service.getAllByExercise(exerciseId);
        return 
                ApiResponse.<List<MultipleChoiceQuestionDTO>>builder()
                        .code(200)
                        .message("Questions fetched successfully")
                        .result(questions)
                        .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<MultipleChoiceQuestionDTO> getById(@PathVariable Long id) {
        MultipleChoiceQuestionDTO question = service.getById(id);
        return 
                ApiResponse.<MultipleChoiceQuestionDTO>builder()
                        .code(200)
                        .message("Question fetched successfully")
                        .result(question)
                        .build();
    }

    @PostMapping("/exercise/{exerciseId}")
    public ApiResponse<MultipleChoiceQuestionDTO> create(
            @PathVariable Long exerciseId,
            @RequestBody MultipleChoiceQuestionDTO dto) {
        MultipleChoiceQuestionDTO created = service.create(exerciseId, dto);
        return ApiResponse.<MultipleChoiceQuestionDTO>builder()
                        .code(201)
                        .message("Question created successfully")
                        .result(created)
                        .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<MultipleChoiceQuestionDTO> update(
            @PathVariable Long id,
            @RequestBody MultipleChoiceQuestionDTO dto) {
        MultipleChoiceQuestionDTO updated = service.update(id, dto);
        return 
                ApiResponse.<MultipleChoiceQuestionDTO>builder()
                        .code(200)
                        .message("Question updated successfully")
                        .result(updated)
                        .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return 
                ApiResponse.<Void>builder()
                        .code(200)
                        .message("Question deleted successfully")
                        .result(null)
                        .build();
    }
}
