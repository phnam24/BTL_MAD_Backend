package com.example.btl_mad_backend.service.submission;

import com.example.btl_mad_backend.dto.submission.SubmissionDTO;
import com.example.btl_mad_backend.entity.Submission;
import com.example.btl_mad_backend.mapper.SubmissionMapper;
import com.example.btl_mad_backend.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

// SubmissionServiceImpl.java
@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final SubmissionMapper submissionMapper;

    @Override
    public SubmissionDTO createSubmission(SubmissionDTO dto) {
        Submission submission = submissionMapper.toEntity(dto);
        submission.setSubmittedAt(new Timestamp(System.currentTimeMillis()));
        return submissionMapper.toDTO(submissionRepository.save(submission));
    }

    @Override
    public List<SubmissionDTO> getAllSubmissions() {
        return submissionRepository.findAll().stream()
                .map(submissionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubmissionDTO getSubmissionById(Long id) {
        return submissionRepository.findById(id)
                .map(submissionMapper::toDTO)
                .orElse(null);
    }
}
