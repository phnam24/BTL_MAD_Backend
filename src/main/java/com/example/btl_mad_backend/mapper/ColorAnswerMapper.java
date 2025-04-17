package com.example.btl_mad_backend.mapper;

import com.example.btl_mad_backend.dto.answer.ColorAnswerDTO;
import com.example.btl_mad_backend.entity.ColorAnswer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ColorAnswerMapper {
    ColorAnswerMapper INSTANCE = Mappers.getMapper(ColorAnswerMapper.class);

    ColorAnswerDTO toDTO(ColorAnswer answer);

    ColorAnswer toEntity(ColorAnswerDTO dto);
}
