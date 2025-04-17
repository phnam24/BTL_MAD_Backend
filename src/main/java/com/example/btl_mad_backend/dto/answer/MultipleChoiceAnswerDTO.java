package com.example.btl_mad_backend.dto.answer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultipleChoiceAnswerDTO {
    private Long id;
    private String answerText;
    private boolean isCorrect;
}
