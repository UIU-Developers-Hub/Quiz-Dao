package com.uiudevelopershub.thinktanku.dto.response;

import com.uiudevelopershub.thinktanku.auth.dto.response.CustomUserResponseDTO;

public  interface QuizResultResponseDto {
    Long getId();

    Boolean getIsCorrect();

    String getUserAnswer();

    QuizSessionResponse getQuizSession();

    interface QuizSessionResponse {
        String getQuizSessionName();
    }

    CustomUserResponse getUser();

    interface CustomUserResponse {
        String getUsername();
        String getEmail();
        Long getId();
    }

    QuizResultResponse getQuiz();

    interface QuizResultResponse {
        Long getId();

        String getQuestionTitle();

        String getOptionOne();

        String getOptionTwo();

        String getOptionThree();

        String getOptionFour();

        String getQuestionAnswer();
    }
}
