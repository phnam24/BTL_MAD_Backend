package com.example.btl_mad_backend.dto.answer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountingAnswerDTO {
    private Long id;
    private String objectName;
    private int correctCount;
}
