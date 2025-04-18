package com.example.btl_mad_backend.repository;

import com.example.btl_mad_backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> getAllByOrderByScoreDesc();
    public List<Student> getAllByGradeOrderByScoreDesc(int grade);
}
