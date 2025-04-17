package com.example.btl_mad_backend.controller;

import com.example.btl_mad_backend.dto.ApiResponse;
import com.example.btl_mad_backend.dto.submission.SubmissionDTO;
import com.example.btl_mad_backend.service.submission.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// SubmissionController.java
@RestController
@RequestMapping("/v1/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping
    public ResponseEntity<ApiResponse<SubmissionDTO>> create(@RequestBody SubmissionDTO dto) {
        return ResponseEntity.ok(ApiResponse.<SubmissionDTO>builder()
                .message("Created successfully")
                .result(submissionService.createSubmission(dto))
                .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubmissionDTO>>> getAll() {
        return ResponseEntity.ok(ApiResponse.<List<SubmissionDTO>>builder()
                .message("Fetched all submissions")
                .result(submissionService.getAllSubmissions())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SubmissionDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.<SubmissionDTO>builder()
                .message("Fetched submission")
                .result(submissionService.getSubmissionById(id))
                .build());
    }
}
