package com.example.btl_mad_backend.service.question;

import com.example.btl_mad_backend.dto.question.CountingQuestionCreateDTO;
import com.example.btl_mad_backend.dto.question.CountingQuestionDTO;
import com.example.btl_mad_backend.entity.CountingAnswer;
import com.example.btl_mad_backend.entity.CountingQuestion;
import com.example.btl_mad_backend.entity.Exercise;
import com.example.btl_mad_backend.mapper.CountingAnswerMapper;
import com.example.btl_mad_backend.mapper.CountingQuestionMapper;
import com.example.btl_mad_backend.repository.CountingAnswerRepository;
import com.example.btl_mad_backend.repository.CountingQuestionRepository;
import com.example.btl_mad_backend.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountingQuestionServiceImpl implements CountingQuestionService {

    private final CountingQuestionRepository questionRepo;
    private final CountingAnswerRepository answerRepo;
    private final ExerciseRepository exerciseRepo;

    private final CountingQuestionMapper questionMapper;
    private final CountingAnswerMapper answerMapper;

    @Override
    public List<CountingQuestionDTO> getByExerciseId(Long exerciseId) {
        List<CountingQuestion> questions = questionRepo.findByExerciseId(exerciseId);
        return questionMapper.toDTOs(questions);
    }

    @Override
    public CountingQuestionDTO create(CountingQuestionCreateDTO createDTO) {
        Exercise exercise = exerciseRepo.findById(createDTO.getExerciseId())
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        CountingQuestion question = new CountingQuestion();
        question.setExercise(exercise);
        question.setImageUrl(createDTO.getImageUrl());

        question = questionRepo.save(question);

        List<CountingAnswer> answers = answerMapper.toEntities(createDTO.getAnswers());
        for (CountingAnswer answer : answers) {
            answer.setQuestion(question);
        }
        answerRepo.saveAll(answers);

        question.setAnswers(answers);
        return questionMapper.toDTO(question);
    }
}

