package com.example.btl_mad_backend.repository;

import com.example.btl_mad_backend.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    public Optional<Exercise> findById(Long id);
    public List<Exercise> findByUserId(Long id);
    public List<Exercise> findByTitleIsContaining(String title);
    public List<Exercise> findByGrade(int grade);
    public List<Exercise> findByExerciseType(int exerciseType);
    public List<Exercise> findByGradeAndExerciseType(int grade, int exerciseType);
}
