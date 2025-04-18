package com.example.btl_mad_backend.dto.student;

import com.example.btl_mad_backend.entity.Role;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRankingDTO {
    private Long id;
    private String name;
    private int grade;
    private Integer score;
}