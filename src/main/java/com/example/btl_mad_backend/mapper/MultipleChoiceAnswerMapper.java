package com.example.btl_mad_backend.mapper;

import com.example.btl_mad_backend.dto.answer.MultipleChoiceAnswerDTO;
import com.example.btl_mad_backend.entity.MultipleChoiceAnswer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MultipleChoiceAnswerMapper {

    @Mapping(target = "isCorrect", source = "correct")
    MultipleChoiceAnswerDTO toDTO(MultipleChoiceAnswer entity);

    MultipleChoiceAnswer toEntity(MultipleChoiceAnswerDTO dto);

    List<MultipleChoiceAnswerDTO> toDTOs(List<MultipleChoiceAnswer> entities);

    List<MultipleChoiceAnswer> toEntities(List<MultipleChoiceAnswerDTO> dtos);
}
