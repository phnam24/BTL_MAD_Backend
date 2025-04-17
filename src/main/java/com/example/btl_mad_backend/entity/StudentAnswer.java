package com.example.btl_mad_backend.entity;

import jakarta.persistence.*;
import lombok.*;

// StudentAnswer.java
@Entity
@Table(name = "student_answers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "submission_id", nullable = false)
    private Submission submission;

    @Column(name = "question_id", nullable = false)
    private Long questionId;

    @Column(name = "selected_answer", nullable = false)
    private String selectedAnswer;
}
