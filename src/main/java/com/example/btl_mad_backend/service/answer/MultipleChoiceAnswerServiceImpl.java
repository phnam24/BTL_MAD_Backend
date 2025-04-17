package com.example.btl_mad_backend.service.answer;

import com.example.btl_mad_backend.dto.answer.MultipleChoiceAnswerDTO;
import com.example.btl_mad_backend.mapper.MultipleChoiceAnswerMapper;
import com.example.btl_mad_backend.repository.MultipleChoiceAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MultipleChoiceAnswerServiceImpl implements MultipleChoiceAnswerService {

    private final MultipleChoiceAnswerRepository answerRepository;
    @Qualifier("multipleChoiceAnswerMapper")
    private final MultipleChoiceAnswerMapper answerMapper;

    @Override
    public List<MultipleChoiceAnswerDTO> getAnswersByQuestionId(Long questionId) {
        return answerRepository.findByQuestionId(questionId)
                .stream()
                .map(answerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
