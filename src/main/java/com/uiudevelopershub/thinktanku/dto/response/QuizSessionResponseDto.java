package com.uiudevelopershub.thinktanku.dto.response;

import java.util.Set;

/**
 * Projection for {@link com.uiudevelopershub.thinktanku.model.quizsession.QuizSession}
 */
public interface QuizSessionResponseDto {

  //  String getSessionId();

    String getQuizSessionName();

    Set<QuizInfo> getQuizzes();

    /**
     * Projection for {@link com.uiudevelopershub.thinktanku.model.quiz.Quiz}
     */
    interface QuizInfo {
        Long getId();

        String getQuestionTitle();

        String getQuestionAnswer();

        String getOptionOne();

        String getOptionTwo();

        String getOptionThree();

        String getOptionFour();
    }
}