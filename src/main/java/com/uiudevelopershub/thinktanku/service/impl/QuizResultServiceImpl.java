package com.uiudevelopershub.thinktanku.service.impl;


import com.uiudevelopershub.thinktanku.model.quizresult.QuizResult;
import com.uiudevelopershub.thinktanku.repository.quizresultrepo.QuizResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizResultServiceImpl {

    private final QuizResultRepo quizResultRepository;

    @Autowired
    public QuizResultServiceImpl(QuizResultRepo quizResultRepository) {
        this.quizResultRepository = quizResultRepository;
    }

    public void submitAnswer(Long userId, Long quizSessionId, Long questionId, String userAnswer) {
        boolean isCorrect = checkAnswer(questionId, userAnswer);
//
//        QuizResult quizResult = new QuizResult();
//        quizResult.setUserId(userId);
//        quizResult.setQuizSessionId(quizSessionId);
//        quizResult.setQuestionId(questionId);
//        quizResult.setIsCorrect(isCorrect);
//
//        quizResultRepository.save(quizResult);
    }

    public long countCorrectAnswers(Long quizSessionId, Long userId) {
        return quizResultRepository.countByQuizSessionIdAndUserIdAndIsCorrect(quizSessionId, userId);
    }

    private boolean checkAnswer(Long questionId, String userAnswer) {
        String correctAnswer = getCorrectAnswerFromDB(questionId);
        return userAnswer.equals(correctAnswer);
    }

    private String getCorrectAnswerFromDB(Long questionId) {
// Implement the logic to fetch the correct answer from the database
        return "correct_answer"; // Placeholder
    }
}
