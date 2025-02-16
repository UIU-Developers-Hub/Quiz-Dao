package com.uiudevelopershub.thinktanku.service;


import com.uiudevelopershub.thinktanku.dto.request.QuizSessionRequestDto;
import com.uiudevelopershub.thinktanku.dto.response.QuizSessionGetAllResponse;
import com.uiudevelopershub.thinktanku.dto.response.QuizSessionResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface QuizSessionService {

    void CreateQuizSession(QuizSessionRequestDto quizSessionRequestDto, MultipartFile heroImageFile)throws IOException;

    QuizSessionResponseDto GetQuizSessionById(Long quizSessionId);

    void DeleteQuizSessionById(Long quizSessionId);

    List<QuizSessionGetAllResponse> QuizSessionGetAll();

    List<QuizSessionGetAllResponse> QuizSessionSearchByName(String name);
}
