package com.example.btl_mad_backend.repository;

import com.example.btl_mad_backend.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// SubmissionRepository.java
@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
