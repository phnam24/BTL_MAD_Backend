package com.example.btl_mad_backend.dto.submission;

import lombok.*;
// StudentAnswerDTO.java
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentAnswerDTO {
    private Long id;
    private Long submissionId;
    private Long questionId;
    private String selectedAnswer;
}
