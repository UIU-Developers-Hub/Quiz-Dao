package com.uiudevelopershub.thinktanku.controller;


import com.uiudevelopershub.thinktanku.service.impl.QuizResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizResultController {
    @Autowired
    private QuizResultServiceImpl quizResultService;

    @PostMapping("/submitAnswer")
    public ResponseEntity<?> submitAnswer(
            @RequestParam Long userId,
            @RequestParam Long quizSessionId,
            @RequestParam Long questionId,
            @RequestParam String answer) {
        quizResultService.submitAnswer(userId, quizSessionId, questionId, answer);
        return ResponseEntity.ok().body("Answer submitted successfully");
    }

    @GetMapping("/countCorrectAnswers/{quizSessionId}/{userId}")
    public ResponseEntity<Long> countCorrectAnswers(@PathVariable Long quizSessionId, @PathVariable Long userId) {
        long correctAnswersCount = quizResultService.countCorrectAnswers(quizSessionId, userId);
        return ResponseEntity.ok().body(correctAnswersCount);
    }
}
