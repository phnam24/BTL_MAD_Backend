package com.example.btl_mad_backend.service.question;

import com.example.btl_mad_backend.dto.question.MultipleChoiceQuestionDTO;
import com.example.btl_mad_backend.entity.Exercise;
import com.example.btl_mad_backend.entity.MultipleChoiceAnswer;
import com.example.btl_mad_backend.entity.MultipleChoiceQuestion;
import com.example.btl_mad_backend.mapper.MultipleChoiceQuestionMapper;
import com.example.btl_mad_backend.repository.ExerciseRepository;
import com.example.btl_mad_backend.repository.MultipleChoiceQuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MultipleChoiceQuestionServiceImpl implements MultipleChoiceQuestionService {

    private final MultipleChoiceQuestionRepository questionRepository;
    private final ExerciseRepository exerciseRepository;
    @Qualifier("multipleChoiceQuestionMapper")
    private final MultipleChoiceQuestionMapper mapper;

    @Override
    public List<MultipleChoiceQuestionDTO> getAllByExercise(Long exerciseId) {
        List<MultipleChoiceQuestion> rs = questionRepository.findByExerciseId(exerciseId);
        return questionRepository.findByExerciseId(exerciseId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MultipleChoiceQuestionDTO getById(Long id) {
        MultipleChoiceQuestion question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));
        return mapper.toDTO(question);
    }

    @Override
    public MultipleChoiceQuestionDTO create(Long exerciseId, MultipleChoiceQuestionDTO dto) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new EntityNotFoundException("Exercise not found"));

        MultipleChoiceQuestion question = mapper.toEntity(dto);
        question.setExercise(exercise);
        question.getAnswers().forEach(ans -> ans.setQuestion(question)); // quan trọng!

        return mapper.toDTO(questionRepository.save(question));
    }

    @Override
    public MultipleChoiceQuestionDTO update(Long id, MultipleChoiceQuestionDTO dto) {
        MultipleChoiceQuestion existing = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));

        existing.setQuestion(dto.getQuestion());

        // Optional: update answers logic here
        // For simplicity, replace all:
        existing.getAnswers().clear();
        List<MultipleChoiceAnswer> newAnswers = dto.getAnswers().stream()
                .map(answerDto -> {
                    MultipleChoiceAnswer a = new MultipleChoiceAnswer();
                    a.setAnswerText(answerDto.getAnswerText());
                    a.setCorrect(answerDto.isCorrect());
                    a.setQuestion(existing);
                    return a;
                })
                .toList();

        existing.getAnswers().addAll(newAnswers);

        return mapper.toDTO(questionRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }
}
