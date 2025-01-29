package com.uiudevelopershub.thinktanku.dto.response;

public  interface QuizResultResponseDto {
    Long getId();

    Long getUserId();

    Long getQuizSessionId();

    Long getQuestionId();

    Boolean getIsCorrect();

}
