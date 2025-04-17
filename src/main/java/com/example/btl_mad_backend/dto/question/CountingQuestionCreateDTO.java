package com.example.btl_mad_backend.dto.question;

import com.example.btl_mad_backend.dto.answer.CountingAnswerCreateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountingQuestionCreateDTO {
    private Long exerciseId;
    private String imageUrl;
    private List<CountingAnswerCreateDTO> answers;
}
