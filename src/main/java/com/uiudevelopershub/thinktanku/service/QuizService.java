package com.uiudevelopershub.thinktanku.service;

import com.uiudevelopershub.thinktanku.model.quiz.Quiz;

public interface QuizService {

    void createQuiz(Quiz quiz);
    Quiz getAllQuiz(Long id);
    void DeleteQuiz(Long id);

}
