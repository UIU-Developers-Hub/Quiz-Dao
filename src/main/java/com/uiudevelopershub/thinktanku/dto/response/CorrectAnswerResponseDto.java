package com.uiudevelopershub.thinktanku.dto.response;

public interface CorrectAnswerResponseDto {
    Long getId();

    String getQuestionTitle();

    String getOptionOne();

    String getOptionTwo();

    String getOptionThree();

    String getOptionFour();

    String getQuestionAnswer();
}
