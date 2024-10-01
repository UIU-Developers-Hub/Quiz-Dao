package com.uiudevelopershub.thinktanku.service.impl;

import com.uiudevelopershub.thinktanku.model.quiz.Quiz;
import com.uiudevelopershub.thinktanku.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {
    public QuizService quizService;

    @Autowired
    public QuizServiceImpl(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public void createQuiz(Quiz quiz) {

    }

    @Override
    public Quiz getAllQuiz(Long id) {
        return null;
    }

    @Override
    public void DeleteQuiz(Long id) {

    }
}
