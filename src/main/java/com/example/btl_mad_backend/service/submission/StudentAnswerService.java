package com.example.btl_mad_backend.service.submission;

import com.example.btl_mad_backend.dto.submission.StudentAnswerDTO;

import java.util.List;

// StudentAnswerService.java
public interface StudentAnswerService {
    StudentAnswerDTO createStudentAnswer(StudentAnswerDTO dto);
    List<StudentAnswerDTO> getAnswersBySubmissionId(Long submissionId);
}
