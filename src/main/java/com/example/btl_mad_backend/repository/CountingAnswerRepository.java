package com.example.btl_mad_backend.repository;

import com.example.btl_mad_backend.entity.CountingAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountingAnswerRepository extends JpaRepository<CountingAnswer, Long> {
    List<CountingAnswer> findByQuestionId(Long questionId);
}
