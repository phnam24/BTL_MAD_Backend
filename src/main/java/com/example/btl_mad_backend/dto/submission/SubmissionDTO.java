package com.example.btl_mad_backend.dto.submission;

import lombok.*;

import java.sql.Timestamp;

// SubmissionDTO.java
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionDTO {
    private Long id;
    private Long studentId;
    private Long exerciseId;
    private Integer score;
    private Timestamp submittedAt;
}
