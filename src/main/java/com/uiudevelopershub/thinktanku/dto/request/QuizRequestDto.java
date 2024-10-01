package com.uiudevelopershub.thinktanku.dto.request;

import com.uiudevelopershub.thinktanku.model.quizsession.QuizSession;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;

public record QuizRequestDto(
      Long id,

      String questionTitle,

      String questionAnswer,

      String optionOne,

      String optionTwo,

      String optionThree,

      String optionFour,

      Long quizSessionId

) {
}
