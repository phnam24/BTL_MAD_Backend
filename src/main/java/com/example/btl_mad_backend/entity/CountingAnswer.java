package com.example.btl_mad_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "counting_answers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountingAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private CountingQuestion question;

    @Column(name = "object_name", nullable = false)
    private String objectName;

    @Column(name = "correct_count", nullable = false)
    private int correctCount;
}
