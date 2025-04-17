package com.example.btl_mad_backend.repository;

import com.example.btl_mad_backend.entity.ColorAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorAnswerRepository extends JpaRepository<ColorAnswer, Long> {
    List<ColorAnswer> findByQuestionId(Long questionId);
}
