package com.example.btl_mad_backend.mapper;

import com.example.btl_mad_backend.dto.question.CountingQuestionDTO;
import com.example.btl_mad_backend.entity.CountingQuestion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CountingAnswerMapper.class)
public interface CountingQuestionMapper {
    CountingQuestionDTO toDTO(CountingQuestion entity);
    CountingQuestion toEntity(CountingQuestionDTO dto);
    List<CountingQuestionDTO> toDTOs(List<CountingQuestion> entities);

    // Nếu bạn muốn dùng mapper để tạo entity từ DTO tạo mới:
    // CountingQuestion toEntity(CountingQuestionCreateDTO dto); (thường sẽ tự xử lý thủ công vì liên quan exercise và answer)
}

