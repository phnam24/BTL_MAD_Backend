package com.example.btl_mad_backend.service.submission;

import com.example.btl_mad_backend.dto.submission.StudentAnswerDTO;
import com.example.btl_mad_backend.entity.StudentAnswer;
import com.example.btl_mad_backend.mapper.StudentAnswerMapper;
import com.example.btl_mad_backend.repository.StudentAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// StudentAnswerServiceImpl.java
@Service
@RequiredArgsConstructor
public class StudentAnswerServiceImpl implements StudentAnswerService {

    private final StudentAnswerRepository studentAnswerRepository;
    private final StudentAnswerMapper studentAnswerMapper;

    @Override
    public StudentAnswerDTO createStudentAnswer(StudentAnswerDTO dto) {
        StudentAnswer entity = studentAnswerMapper.toEntity(dto);
        return studentAnswerMapper.toDTO(studentAnswerRepository.save(entity));
    }

    @Override
    public List<StudentAnswerDTO> getAnswersBySubmissionId(Long submissionId) {
        return studentAnswerRepository.findBySubmissionId(submissionId)
                .stream()
                .map(studentAnswerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
