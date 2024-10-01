package com.uiudevelopershub.thinktanku.service;

import com.uiudevelopershub.thinktanku.dto.request.QuizSessionRequestDto;
import com.uiudevelopershub.thinktanku.dto.response.QuizSessionResponseDto;
import com.uiudevelopershub.thinktanku.model.quizsession.QuizSession;

public interface QuizSessionService {

    void CreateQuizSession(QuizSessionRequestDto quizSessionRequestDto);

    QuizSessionResponseDto GetQuizSessionById(Long quizSessionId);

    void DeleteQuizSessionById(Long quizSessionId);


}
