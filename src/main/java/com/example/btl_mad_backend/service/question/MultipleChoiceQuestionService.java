package com.example.btl_mad_backend.service.question;

import com.example.btl_mad_backend.dto.question.MultipleChoiceQuestionDTO;

import java.util.List;

public interface MultipleChoiceQuestionService {
    List<MultipleChoiceQuestionDTO> getAllByExercise(Long exerciseId);
    MultipleChoiceQuestionDTO getById(Long id);
    MultipleChoiceQuestionDTO create(Long exerciseId, MultipleChoiceQuestionDTO dto);
    MultipleChoiceQuestionDTO update(Long id, MultipleChoiceQuestionDTO dto);
    void delete(Long id);
}
