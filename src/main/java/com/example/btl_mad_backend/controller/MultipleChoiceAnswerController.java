package com.example.btl_mad_backend.controller;

import com.example.btl_mad_backend.dto.ApiResponse;
import com.example.btl_mad_backend.dto.answer.MultipleChoiceAnswerDTO;
import com.example.btl_mad_backend.service.answer.MultipleChoiceAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/answers")
@RequiredArgsConstructor
public class MultipleChoiceAnswerController {

    private final MultipleChoiceAnswerService answerService;

    @GetMapping("/question/{questionId}")
    public ApiResponse<List<MultipleChoiceAnswerDTO>> getAnswersByQuestionId(@PathVariable Long questionId) {
        List<MultipleChoiceAnswerDTO> answers = answerService.getAnswersByQuestionId(questionId);
        return ApiResponse.<List<MultipleChoiceAnswerDTO>>builder()
                        .code(200)
                        .message("Answers fetched successfully")
                        .result(answers)
                        .build();
    }
}
