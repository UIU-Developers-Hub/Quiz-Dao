package com.uiudevelopershub.thinktanku.dto.request;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public record QuizResultRequestDto(

    Long userId,

    Long quizSessionId,

    Long questionId,

    Boolean isCorrect,

    LocalDateTime time

) {

}
