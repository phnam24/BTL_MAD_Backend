package com.example.btl_mad_backend.dto.question;

import com.example.btl_mad_backend.dto.answer.MultipleChoiceAnswerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultipleChoiceQuestionDTO {
    private Long id;
    private Long exerciseId;
    private String question;
    private List<MultipleChoiceAnswerDTO> answers;
}
