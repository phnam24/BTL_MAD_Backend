package com.example.btl_mad_backend.service.student;

import com.example.btl_mad_backend.dto.student.StudentRankingDTO;
import com.example.btl_mad_backend.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentRankingDTO> getLeaderBoard();
    List<StudentRankingDTO> getLeaderBoardByGrade(int grade);
}
