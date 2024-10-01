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
    public ResponseEntity<PageResponseDto>getQuizList(
            @RequestParam(value = "pageNo",
            defaultValue = "1",
            required = false)

             int pageNo
            ,@RequestParam(
            value = "pageSize",
            defaultValue = "10",
            required = false
    ) int pageSize) {
        return ResponseEntity.ok(quizService.getAllQuiz(pageNo, pageSize));
    }

    @DeleteMapping("{id}")
    public String DeleteQuiz(@PathVariable  Long id) {
        quizService.DeleteQuiz(id);
        return "Quiz deleted";
    }

}
