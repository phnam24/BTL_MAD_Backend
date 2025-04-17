package com.example.btl_mad_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    private Long userId;

    @OneToOne
    @MapsId  // Dùng ID của User
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 50)
    private String grade;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private int score;

    public Student() {
    }

    public Student(User user, String grade) {
        this.user = user;
        this.grade = grade;
        this.score = 0;
    }
}
