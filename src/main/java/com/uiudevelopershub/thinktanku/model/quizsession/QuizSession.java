package com.uiudevelopershub.thinktanku.model.quizsession;


import com.uiudevelopershub.thinktanku.model.quiz.Quiz;
import com.uiudevelopershub.thinktanku.model.quizresult.QuizResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class QuizSession {

  //  @SequenceGenerator( name = "quiz_session_gen", sequenceName = "quiz_session_seq" )

//
    @Column( nullable = false )
    private String sessionId = UUID.randomUUID().toString();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false )
    private String QuizSessionName;

    @OneToMany( mappedBy = "quizSession", cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<Quiz> quizzes = new HashSet<>();

    @OneToMany(mappedBy = "quizSession")  // 'quizSession' refers to the field in QuizResult class
    private List<QuizResult> quizResults;

}