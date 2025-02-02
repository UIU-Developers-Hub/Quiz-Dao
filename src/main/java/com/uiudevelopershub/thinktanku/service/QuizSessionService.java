package com.uiudevelopershub.thinktanku.service;


import com.uiudevelopershub.thinktanku.dto.request.QuizSessionRequestDto;
import com.uiudevelopershub.thinktanku.dto.response.QuizSessionGetAllResponse;
import com.uiudevelopershub.thinktanku.dto.response.QuizSessionResponseDto;

import java.util.List;

public interface QuizSessionService {

    void CreateQuizSession(QuizSessionRequestDto quizSessionRequestDto);

    QuizSessionResponseDto GetQuizSessionById(Long quizSessionId);

    void DeleteQuizSessionById(Long quizSessionId);

    List<QuizSessionGetAllResponse> QuizSessionGetAll();

    QuizSessionGetAllResponse QuizSessionSearchByName(String name);
}
