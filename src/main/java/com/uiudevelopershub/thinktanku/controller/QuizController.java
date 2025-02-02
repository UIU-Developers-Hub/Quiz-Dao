package com.uiudevelopershub.thinktanku.controller;

import com.uiudevelopershub.thinktanku.dto.request.QuizRequestDto;
import com.uiudevelopershub.thinktanku.dto.response.PageResponseDto;
import com.uiudevelopershub.thinktanku.dto.response.QuizResponseDto;
import com.uiudevelopershub.thinktanku.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("Quiz")
public class QuizController {

    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
//    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @PostMapping("Create")
    public String createQuiz(QuizRequestDto quizRequestDto) {
        quizService.createQuiz(quizRequestDto);
        return "Quiz created";
    }

//    @GetMapping("Get-All")
//    public ResponseEntity<PageResponseDto>getQuizList(
//            @RequestParam(value = "pageNo",
//            defaultValue = "1",
//            required = false)
//
//             int pageNo
//            ,@RequestParam(
//            value = "pageSize",
//            defaultValue = "10",
//            required = false
//    ) int pageSize) {
//        return ResponseEntity.ok(quizService.getAllQuiz(pageNo, pageSize));
//    }

//    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @DeleteMapping("{id}")
    public String DeleteQuiz(@PathVariable  Long id) {
        quizService.DeleteQuiz(id);
        return "Quiz deleted";
    }

    @GetMapping("QuizSession/{quizSessionId}")
    public ResponseEntity<List<QuizResponseDto>>getAllByQuizSessionId(@PathVariable Long quizSessionId) {
        return ResponseEntity.ok(quizService.findAllQuizByQuizSessionId(quizSessionId));
    }

}
