package com.uiudevelopershub.thinktanku.repository.quizSessionRepo;

import com.uiudevelopershub.thinktanku.model.quizsession.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizSessionRepo extends JpaRepository<QuizSession, Long> {
}
