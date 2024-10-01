package com.uiudevelopershub.thinktanku.model.quizsession;

import com.uiudevelopershub.thinktanku.model.quiz.Quiz;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class QuizSession {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "quiz_session_gen" )
    @SequenceGenerator( name = "quiz_session_gen", sequenceName = "quiz_session_seq" )
    private Long id;

    @Column( nullable = false )
    private String sessionId = UUID.randomUUID().toString();

    @Column( nullable = false )
    private String QuizSessionName;

    @OneToMany( mappedBy = "quizSession", cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<Quiz> quizzes = new HashSet<>();
}