package com.example.btl_mad_backend.service.question;

import com.example.btl_mad_backend.dto.question.CountingQuestionCreateDTO;
import com.example.btl_mad_backend.dto.question.CountingQuestionDTO;

import java.util.List;

public interface CountingQuestionService {
    List<CountingQuestionDTO> getByExerciseId(Long exerciseId);
    CountingQuestionDTO create(CountingQuestionCreateDTO createDTO);

}
