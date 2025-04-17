package com.example.btl_mad_backend.service.answer;

import com.example.btl_mad_backend.dto.answer.MultipleChoiceAnswerDTO;

import java.util.List;

public interface MultipleChoiceAnswerService {
    List<MultipleChoiceAnswerDTO> getAnswersByQuestionId(Long questionId);
}
