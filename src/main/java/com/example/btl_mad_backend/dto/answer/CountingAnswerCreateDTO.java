package com.example.btl_mad_backend.dto.answer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountingAnswerCreateDTO {
    private String objectName;
    private int correctCount;
}

