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
    public ResponseEntity<ApiResponse<List<MultipleChoiceQuestionDTO>>> getByExercise(@PathVariable Long exerciseId) {
        List<MultipleChoiceQuestionDTO> questions = service.getAllByExercise(exerciseId);
        return ResponseEntity.ok(
                ApiResponse.<List<MultipleChoiceQuestionDTO>>builder()
                        .code(200)
                        .message("Questions fetched successfully")
                        .result(questions)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MultipleChoiceQuestionDTO>> getById(@PathVariable Long id) {
        MultipleChoiceQuestionDTO question = service.getById(id);
        return ResponseEntity.ok(
                ApiResponse.<MultipleChoiceQuestionDTO>builder()
                        .code(200)
                        .message("Question fetched successfully")
                        .result(question)
                        .build()
        );
    }

    @PostMapping("/exercise/{exerciseId}")
    public ResponseEntity<ApiResponse<MultipleChoiceQuestionDTO>> create(
            @PathVariable Long exerciseId,
            @RequestBody MultipleChoiceQuestionDTO dto) {
        MultipleChoiceQuestionDTO created = service.create(exerciseId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<MultipleChoiceQuestionDTO>builder()
                        .code(201)
                        .message("Question created successfully")
                        .result(created)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MultipleChoiceQuestionDTO>> update(
            @PathVariable Long id,
            @RequestBody MultipleChoiceQuestionDTO dto) {
        MultipleChoiceQuestionDTO updated = service.update(id, dto);
        return ResponseEntity.ok(
                ApiResponse.<MultipleChoiceQuestionDTO>builder()
                        .code(200)
                        .message("Question updated successfully")
                        .result(updated)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .code(200)
                        .message("Question deleted successfully")
                        .result(null)
                        .build()
        );
    }
}
