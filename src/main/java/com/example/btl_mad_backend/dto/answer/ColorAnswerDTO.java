package com.example.btl_mad_backend.dto.answer;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColorAnswerDTO {
    private Long id;
    private int correctPosition;
}
