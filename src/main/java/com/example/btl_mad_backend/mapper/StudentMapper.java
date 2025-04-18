package com.example.btl_mad_backend.mapper;

import com.example.btl_mad_backend.dto.student.StudentRankingDTO;
import com.example.btl_mad_backend.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.id", target = "id")
    StudentRankingDTO toStudentRankingDTO(Student student);
}
