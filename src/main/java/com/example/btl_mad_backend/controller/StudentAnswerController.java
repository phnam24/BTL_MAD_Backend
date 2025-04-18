package com.example.btl_mad_backend.controller;

import com.example.btl_mad_backend.dto.ApiResponse;
import com.example.btl_mad_backend.dto.submission.StudentAnswerDTO;
import com.example.btl_mad_backend.service.submission.StudentAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// StudentAnswerController.java
@RestController
@RequestMapping("/api/student-answers")
@RequiredArgsConstructor
public class StudentAnswerController {

    private final StudentAnswerService studentAnswerService;

    @PostMapping
    public ApiResponse<StudentAnswerDTO> create(@RequestBody StudentAnswerDTO dto) {
        return ApiResponse.<StudentAnswerDTO>builder()
                .message("Answer saved")
                .result(studentAnswerService.createStudentAnswer(dto))
                .build();
    }

    @GetMapping("/submission/{submissionId}")
    public ApiResponse<List<StudentAnswerDTO>> getBySubmission(@PathVariable Long submissionId) {
        return ApiResponse.<List<StudentAnswerDTO>>builder()
                .message("Answers by submission")
                .result(studentAnswerService.getAnswersBySubmissionId(submissionId))
                .build();
    }
}
