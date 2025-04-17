package com.example.btl_mad_backend.dto.question;

import com.example.btl_mad_backend.dto.answer.ColorAnswerDTO;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColorQuestionDTO {
    private Long id;
    private String imageUrl;
    private Long exerciseId;
    private List<ColorAnswerDTO> answers;
}
