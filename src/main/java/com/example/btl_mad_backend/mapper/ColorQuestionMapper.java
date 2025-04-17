package com.example.btl_mad_backend.mapper;

import com.example.btl_mad_backend.dto.question.ColorQuestionDTO;
import com.example.btl_mad_backend.entity.ColorQuestion;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ColorAnswerMapper.class})
public interface ColorQuestionMapper {
    ColorQuestionMapper INSTANCE = Mappers.getMapper(ColorQuestionMapper.class);

    @Mapping(source = "exercise.id", target = "exerciseId")
    ColorQuestionDTO toDTO(ColorQuestion question);

    @Mapping(source = "exerciseId", target = "exercise.id")
    ColorQuestion toEntity(ColorQuestionDTO dto);
}
