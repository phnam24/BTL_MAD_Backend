package com.example.btl_mad_backend.mapper;

import com.example.btl_mad_backend.dto.submission.StudentAnswerDTO;
import com.example.btl_mad_backend.entity.StudentAnswer;
import org.mapstruct.Mapper;

// StudentAnswerMapper.java
@Mapper(componentModel = "spring")
public interface StudentAnswerMapper {
    StudentAnswerDTO toDTO(StudentAnswer entity);
    StudentAnswer toEntity(StudentAnswerDTO dto);
}
