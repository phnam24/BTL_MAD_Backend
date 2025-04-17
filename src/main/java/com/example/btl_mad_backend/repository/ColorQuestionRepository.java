package com.example.btl_mad_backend.repository;

import com.example.btl_mad_backend.entity.ColorQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorQuestionRepository extends JpaRepository<ColorQuestion, Long> {
    List<ColorQuestion> findByExerciseId(Long exerciseId);
}
