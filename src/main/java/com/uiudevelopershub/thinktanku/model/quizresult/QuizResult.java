package com.uiudevelopershub.thinktanku.model.quizresult;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long quizSessionId;

    @Column(nullable = false)
    private Long questionId;

    @Column(nullable = false)
    private Boolean isCorrect;

    @Column(nullable = false)
    private LocalDateTime time;

//    public QuizResult(Long userId, Long quizSessionId, Long questionId, boolean isCorrect, LocalDateTime now) {
//
//   this.userId = userId;
//    this.quizSessionId = quizSessionId;
//    this.questionId = questionId;
//    this.isCorrect = isCorrect;
//    this.time = now;
//    }
}
