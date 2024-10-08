package com.uiudevelopershub.thinktanku.service;

import com.uiudevelopershub.thinktanku.model.quizresult.QuizResult;

public interface QuizResultService {
    public void submitAnswer(Long userId, Long quizSessionId, Long questionId, String userAnswer);
    public long countCorrectAnswers(Long quizSessionId);
    public  boolean checkAnswer(Long questionId, String userAnswer);
    public String getCorrectAnswerFromDB(Long questionId);
}
