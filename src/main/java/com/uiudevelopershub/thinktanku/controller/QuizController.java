package com.uiudevelopershub.thinktanku.controller;

import com.uiudevelopershub.thinktanku.dto.request.QuizRequestDto;
import com.uiudevelopershub.thinktanku.dto.response.PageResponseDto;
import com.uiudevelopershub.thinktanku.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Quiz")
public class QuizController {

    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("Create")
    public String createQuiz(QuizRequestDto quizRequestDto) {
        quizService.createQuiz(quizRequestDto);
        return "Quiz created";
    }

    @GetMapping("Get-All")
    public ResponseEntity<PageResponseDto>getQuizList(int pageNo, int pageSize) {
        return ResponseEntity.ok(quizService.getAllQuiz(pageNo, pageSize));
    }

    @DeleteMapping
    public String DeleteQuiz(Long quizId) {
        quizService.DeleteQuiz(quizId);
        return "Quiz deleted";
    }

}
