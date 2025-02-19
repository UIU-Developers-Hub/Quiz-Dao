package com.uiudevelopershub.thinktanku.service;

import com.uiudevelopershub.thinktanku.dto.request.QuizRequestDto;
import com.uiudevelopershub.thinktanku.dto.response.PageResponseDto;
import com.uiudevelopershub.thinktanku.dto.response.QuizResponseDto;
import com.uiudevelopershub.thinktanku.model.quiz.Quiz;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuizService {

    void createQuiz(QuizRequestDto quizRequestDto);
//    PageResponseDto getAllQuiz(int pageNo, int pageSize);
    void DeleteQuiz(Long id);


    List<QuizResponseDto> findAllQuizByQuizSessionId(Long quizSessionId);

}
