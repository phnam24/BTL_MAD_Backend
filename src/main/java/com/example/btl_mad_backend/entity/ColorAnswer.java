package com.example.btl_mad_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "color_answers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColorAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private ColorQuestion question;

    @Column(name = "correct_position", nullable = false)
    private int correctPosition;
}
