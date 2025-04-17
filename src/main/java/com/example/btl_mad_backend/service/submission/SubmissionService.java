package com.example.btl_mad_backend.service.submission;

import com.example.btl_mad_backend.dto.submission.SubmissionDTO;

import java.util.List;

// SubmissionService.java
public interface SubmissionService {
    SubmissionDTO createSubmission(SubmissionDTO dto);
    List<SubmissionDTO> getAllSubmissions();
    SubmissionDTO getSubmissionById(Long id);
}
