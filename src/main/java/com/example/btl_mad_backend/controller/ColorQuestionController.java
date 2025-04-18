package com.example.btl_mad_backend.controller;

import com.example.btl_mad_backend.dto.ApiResponse;
import com.example.btl_mad_backend.dto.question.ColorQuestionDTO;
import com.example.btl_mad_backend.service.question.ColorQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/v1/color-questions")
@RequiredArgsConstructor
public class ColorQuestionController {

    private final ColorQuestionService service;

    @GetMapping
    public ApiResponse<List<ColorQuestionDTO>> getAll() {
        return ApiResponse.<List<ColorQuestionDTO>>builder()
                        .message("Fetched all successfully")
                        .result(service.getAll())
                        .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ColorQuestionDTO> getById(@PathVariable Long id) {
        return ApiResponse.<ColorQuestionDTO>builder()
                        .message("Fetched successfully")
                        .result(service.getById(id))
                        .build();
    }

    @PostMapping
    public ApiResponse<ColorQuestionDTO> create(@RequestBody ColorQuestionDTO dto) {
        return ApiResponse.<ColorQuestionDTO>builder()
                        .message("Created successfully")
                        .result(service.create(dto))
                        .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ColorQuestionDTO> update(@PathVariable Long id,
                                                                @RequestBody ColorQuestionDTO dto) {
        return ApiResponse.<ColorQuestionDTO>builder()
                        .message("Updated successfully")
                        .result(service.update(id, dto))
                        .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.<Void>builder()
                        .message("Deleted successfully")
                        .build();
    }
}
