package com.uiudevelopershub.thinktanku.controller;


import com.uiudevelopershub.thinktanku.dto.response.QuizResultResponseDto;
import com.uiudevelopershub.thinktanku.service.QuizResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizResultController {

    private QuizResultService quizResultService;

    public QuizResultController(QuizResultService quizResultService) {
        this.quizResultService = quizResultService;
    }

    @PostMapping("/submitAnswer")
    public ResponseEntity<?> submitAnswer(
            @RequestParam Long userId,
            @RequestParam Long quizSessionId,
            @RequestParam Long questionId,
            @RequestParam String answer) {
        quizResultService.submitAnswer(userId, quizSessionId, questionId, answer);
        return ResponseEntity.ok().body("Answer submitted successfully");
    }

//    @GetMapping("/countCorrectAnswers/{quizSessionId}/{userId}")
//    public ResponseEntity<Long> countCorrectAnswers(@PathVariable Long quizSessionId, @PathVariable Long userId) {
//        long correctAnswersCount = quizResultService.countCorrectAnswers(quizSessionId, userId);
//        return ResponseEntity.ok().body(correctAnswersCount);
//    }



//quizSubmission logic done with showing 500 to let user give quiz and 200 to directly showing the result page
    @GetMapping("{quizSessionId}/{userId}")
    public ResponseEntity<List<QuizResultResponseDto>>findQuizResultById(@PathVariable Long quizSessionId, @PathVariable Long userId) {
        return ResponseEntity.ok(quizResultService.getCorrectAnswerById(quizSessionId, userId));
    }
}
