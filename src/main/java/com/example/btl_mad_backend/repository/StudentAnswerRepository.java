package com.example.btl_mad_backend.repository;

import com.example.btl_mad_backend.entity.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// StudentAnswerRepository.java
@Repository
public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, Long> {
    List<StudentAnswer> findBySubmissionId(Long submissionId);
}
