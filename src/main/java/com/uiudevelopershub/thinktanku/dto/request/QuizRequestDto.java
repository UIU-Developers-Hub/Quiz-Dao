package com.uiudevelopershub.thinktanku.dto.request;




public record QuizRequestDto(

      String questionTitle,

      String questionAnswer,

      String optionOne,

      String optionTwo,

      String optionThree,

      String optionFour,

      Long quizSessionId

) {
}
