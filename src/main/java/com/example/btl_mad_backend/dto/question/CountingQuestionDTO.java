package com.example.btl_mad_backend.dto.question;

import com.example.btl_mad_backend.dto.answer.CountingAnswerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountingQuestionDTO {
    private Long id;
    private Long exerciseId;
    private String imageUrl;
    private List<CountingAnswerDTO> answers;
}
