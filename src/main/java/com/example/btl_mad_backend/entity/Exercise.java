package com.example.btl_mad_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer exerciseType;

    @Column(nullable = false)
    private String title;

    private int grade;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
