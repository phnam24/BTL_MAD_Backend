package com.example.btl_mad_backend.mapper;

import com.example.btl_mad_backend.dto.answer.CountingAnswerCreateDTO;
import com.example.btl_mad_backend.dto.answer.CountingAnswerDTO;
import com.example.btl_mad_backend.entity.CountingAnswer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountingAnswerMapper {
    CountingAnswerDTO toDTO(CountingAnswer entity);
    CountingAnswer toEntity(CountingAnswerDTO dto);
    CountingAnswer toEntity(CountingAnswerCreateDTO dto); // thêm dòng này
    List<CountingAnswer> toEntities(List<CountingAnswerCreateDTO> dtos); // thêm dòng này
    List<CountingAnswerDTO> toDTOs(List<CountingAnswer> entities);
}
