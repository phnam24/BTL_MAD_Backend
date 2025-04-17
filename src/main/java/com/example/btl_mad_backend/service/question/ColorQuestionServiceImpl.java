package com.example.btl_mad_backend.service.question;

import com.example.btl_mad_backend.dto.question.ColorQuestionDTO;
import com.example.btl_mad_backend.entity.ColorQuestion;
import com.example.btl_mad_backend.mapper.ColorQuestionMapper;
import com.example.btl_mad_backend.repository.ColorQuestionRepository;
import com.example.btl_mad_backend.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorQuestionServiceImpl implements ColorQuestionService {

    private final ColorQuestionRepository questionRepository;
    private final ExerciseRepository exerciseRepository;
    private final ColorQuestionMapper questionMapper;

    @Override
    public List<ColorQuestionDTO> getAll() {
        return questionRepository.findAll()
                .stream()
                .map(questionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ColorQuestionDTO getById(Long id) {
        return questionRepository.findById(id)
                .map(questionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public ColorQuestionDTO create(ColorQuestionDTO dto) {
        ColorQuestion question = questionMapper.toEntity(dto);
        question.setExercise(exerciseRepository.findById(dto.getExerciseId())
                .orElseThrow(() -> new RuntimeException("Exercise not found")));
        return questionMapper.toDTO(questionRepository.save(question));
    }

    @Override
    public ColorQuestionDTO update(Long id, ColorQuestionDTO dto) {
        ColorQuestion question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        question.setImageUrl(dto.getImageUrl());
        return questionMapper.toDTO(questionRepository.save(question));
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }
}
