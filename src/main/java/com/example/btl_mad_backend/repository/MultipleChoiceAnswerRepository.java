package com.example.btl_mad_backend.repository;

import com.example.btl_mad_backend.entity.MultipleChoiceAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultipleChoiceAnswerRepository extends JpaRepository<MultipleChoiceAnswer, Long> {
    List<MultipleChoiceAnswer> findByQuestionId(Long questionId);
}
