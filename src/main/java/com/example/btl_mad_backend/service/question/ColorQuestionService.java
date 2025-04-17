package com.example.btl_mad_backend.service.question;

import com.example.btl_mad_backend.dto.question.ColorQuestionDTO;

import java.util.List;

public interface ColorQuestionService {
    List<ColorQuestionDTO> getAll();

    ColorQuestionDTO getById(Long id);

    ColorQuestionDTO create(ColorQuestionDTO dto);

    ColorQuestionDTO update(Long id, ColorQuestionDTO dto);

    void delete(Long id);
}
