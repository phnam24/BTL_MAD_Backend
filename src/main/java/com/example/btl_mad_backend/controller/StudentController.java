package com.example.btl_mad_backend.controller;


import com.example.btl_mad_backend.dto.ApiResponse;
import com.example.btl_mad_backend.dto.student.StudentRankingDTO;
import com.example.btl_mad_backend.entity.Exercise;
import com.example.btl_mad_backend.entity.Student;
import com.example.btl_mad_backend.repository.StudentRepository;
import com.example.btl_mad_backend.service.exercise.ExerciseService;
import com.example.btl_mad_backend.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/leaderboard")
    public ApiResponse<List<StudentRankingDTO>> getLeaderboard() {
        System.out.println("getLeaderboard" + studentService.getLeaderBoard().toString());
        return ApiResponse.<List<StudentRankingDTO>>builder()
                .result(studentService.getLeaderBoard())
                .build();
    }

    @GetMapping("/leaderboard/grade/{grade}")
    public ApiResponse<List<StudentRankingDTO>> getLeaderboard(@PathVariable int grade) {
        return ApiResponse.<List<StudentRankingDTO>>builder()
                .result(studentService.getLeaderBoardByGrade(grade))
                .build();
    }
}
