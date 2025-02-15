package com.uiudevelopershub.thinktanku.service;

import com.uiudevelopershub.thinktanku.dto.response.QuizResultResponseDto;
import com.uiudevelopershub.thinktanku.dto.response.UserCorrectAnswerResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizResultService {
    public void submitAnswer(Long userId, Long quizSessionId, Long questionId, String userAnswer);
    public List<UserCorrectAnswerResponse> getCorrectAnswersBySession(Long sessionId);

//    List<QuizResultResponseDto> countCorrectAnswers();

    //    public  boolean checkAnswer(Long questionId, String userAnswer);
//    public String getCorrectAnswerFromDB(Long questionId);
   List< QuizResultResponseDto > getCorrectAnswerById(Long quizSessionId, Long userId);
}
