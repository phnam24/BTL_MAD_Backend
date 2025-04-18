package com.example.btl_mad_backend.service.student;

import com.example.btl_mad_backend.dto.student.StudentRankingDTO;
import com.example.btl_mad_backend.entity.Student;
import com.example.btl_mad_backend.mapper.StudentMapper;
import com.example.btl_mad_backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentRankingDTO> getLeaderBoard() {
        return studentRepository.getAllByOrderByScoreDesc().stream().map(studentMapper::toStudentRankingDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentRankingDTO> getLeaderBoardByGrade(int grade) {
        return studentRepository.getAllByGradeOrderByScoreDesc(grade).stream().map(studentMapper::toStudentRankingDTO).collect(Collectors.toList());
    }
}
