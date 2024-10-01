package com.uiudevelopershub.thinktanku.service.impl;

import com.uiudevelopershub.thinktanku.dto.request.QuizSessionRequestDto;
import com.uiudevelopershub.thinktanku.dto.response.CustomUserResponseDTO;
import com.uiudevelopershub.thinktanku.dto.response.QuizSessionResponseDto;
import com.uiudevelopershub.thinktanku.model.quizsession.QuizSession;
import com.uiudevelopershub.thinktanku.repository.quizSessionRepo.QuizSessionRepo;
import com.uiudevelopershub.thinktanku.service.QuizSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class QuizSessionServiceImpl implements QuizSessionService {

   public  QuizSessionRepo quizSessionRepo;

    @Autowired
    public QuizSessionServiceImpl(QuizSessionRepo quizSessionRepo) {
        this.quizSessionRepo = quizSessionRepo;
    }


    @Override
    public void CreateQuizSession(QuizSessionRequestDto quizSessionRequestDto) {
        QuizSession quizSession = new QuizSession();
        quizSession.setQuizSessionName(quizSessionRequestDto.QuizSessionName());
        quizSessionRepo.save(quizSession);
    }

    @Override
    public QuizSessionResponseDto GetQuizSessionById(Long quizSessionId) {
        QuizSessionResponseDto singleQuizSessionById = quizSessionRepo.findQuizSessionById(quizSessionId);
        if (Objects.isNull( singleQuizSessionById ) ) {
            throw new RuntimeException("not found" );
        }
        return singleQuizSessionById;
    }

    @Override
    public void DeleteQuizSessionById(Long quizSessionId) {
      quizSessionRepo.deleteById(quizSessionId);
    }
}
