package com.uiudevelopershub.thinktanku.model.questionsessionperuser;

import com.uiudevelopershub.thinktanku.model.quizsession.QuizSession;
import com.uiudevelopershub.thinktanku.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionSessionPerUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "QuestionSessionPerUser_users",
            joinColumns = @JoinColumn(name = "questionSessionPerUser_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<User> users = new LinkedHashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "QuestionSessionPerUser_quizSessions",
            joinColumns = @JoinColumn(name = "questionSessionPerUser_id"),
            inverseJoinColumns = @JoinColumn(name = "quizSessions_id"))
    private Set<QuizSession> quizSessions = new LinkedHashSet<>();

}
