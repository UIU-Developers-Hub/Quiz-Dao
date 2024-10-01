package com.uiudevelopershub.thinktanku.repository.quizRepo;

import com.uiudevelopershub.thinktanku.model.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {

}
