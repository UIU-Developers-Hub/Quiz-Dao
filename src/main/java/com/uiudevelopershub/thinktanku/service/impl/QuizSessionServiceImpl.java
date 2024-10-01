package com.uiudevelopershub.thinktanku.service.impl;

import com.uiudevelopershub.thinktanku.dto.request.QuizSessionRequestDto;
import com.uiudevelopershub.thinktanku.dto.response.QuizSessionResponseDto;
import com.uiudevelopershub.thinktanku.repository.quizSessionRepo.QuizSessionRepo;
import com.uiudevelopershub.thinktanku.service.QuizSessionService;

public class QuizSessionServiceImpl implements QuizSessionService {

    QuizSessionRepo quizSessionRepo;

    public QuizSessionServiceImpl(QuizSessionRepo quizSessionRepo) {
        this.quizSessionRepo = quizSessionRepo;
    }

    @Override
    public void CreateQuizSession(QuizSessionRequestDto quizSessionRequestDto) {

    }

    @Override
    public QuizSessionResponseDto GetQuizSessionById(Long quizSessionId) {
        return null;
    }

    @Override
    public void DeleteQuizSessionById(Long quizSessionId) {

    }
}
