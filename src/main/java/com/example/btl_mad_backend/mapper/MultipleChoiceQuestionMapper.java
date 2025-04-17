package com.example.btl_mad_backend.mapper;

import com.example.btl_mad_backend.dto.answer.MultipleChoiceAnswerDTO;
import com.example.btl_mad_backend.dto.question.MultipleChoiceQuestionDTO;
import com.example.btl_mad_backend.entity.MultipleChoiceAnswer;
import com.example.btl_mad_backend.entity.MultipleChoiceQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {MultipleChoiceAnswerMapper.class})
public interface MultipleChoiceQuestionMapper {

    @Mapping(source = "exercise.id", target = "exerciseId")
    MultipleChoiceQuestionDTO toDTO(MultipleChoiceQuestion entity);

    @Mapping(target = "exercise", ignore = true) // set manually in service
    @Mapping(target = "answers", expression = "java(mapAnswers(dto.getAnswers()))")
    MultipleChoiceQuestion toEntity(MultipleChoiceQuestionDTO dto);

    List<MultipleChoiceQuestionDTO> toDTOs(List<MultipleChoiceQuestion> entities);

    List<MultipleChoiceQuestion> toEntities(List<MultipleChoiceQuestionDTO> dtos);

    // Helper method for setting parent in manual mapping
    default List<MultipleChoiceAnswer> mapAnswers(List<MultipleChoiceAnswerDTO> dtos) {
        if (dtos == null) return new ArrayList<>();
        List<MultipleChoiceAnswer> entities = toAnswerEntities(dtos);
        entities.forEach(ans -> ans.setQuestion(null)); // question sẽ được set trong service
        return entities;
    }

    @Named("toAnswerEntities")
    List<MultipleChoiceAnswer> toAnswerEntities(List<MultipleChoiceAnswerDTO> dtos);

}
