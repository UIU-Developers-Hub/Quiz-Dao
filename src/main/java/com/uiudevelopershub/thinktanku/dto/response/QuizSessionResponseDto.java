package com.uiudevelopershub.thinktanku.dto.response;

import com.uiudevelopershub.thinktanku.model.quiz.Quiz;

import java.util.Set;

public interface QuizSessionResponseDto {

    String GetQuizSessionName();

    Set<QuizInfo> getQuizInfo();

    interface QuizInfo {
        Long getId();

        String getQuestionTitle();

        String getOptionOne();

        String getOptionTwo();

        String getOptionThree();

        String getOptionFour();

    }
}
