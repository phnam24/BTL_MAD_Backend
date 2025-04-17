package com.example.btl_mad_backend.repository;

import com.example.btl_mad_backend.entity.CountingQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountingQuestionRepository extends JpaRepository<CountingQuestion, Long> {
    List<CountingQuestion> findByExerciseId(Long exerciseId);
}
