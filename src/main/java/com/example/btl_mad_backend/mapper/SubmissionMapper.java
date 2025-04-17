package com.example.btl_mad_backend.mapper;

import com.example.btl_mad_backend.dto.submission.SubmissionDTO;
import com.example.btl_mad_backend.entity.Submission;
import org.mapstruct.Mapper;

// SubmissionMapper.java
@Mapper(componentModel = "spring")
public interface SubmissionMapper {
    SubmissionDTO toDTO(Submission entity);
    Submission toEntity(SubmissionDTO dto);
}
