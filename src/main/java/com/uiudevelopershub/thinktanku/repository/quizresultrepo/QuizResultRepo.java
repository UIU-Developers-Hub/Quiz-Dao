package com.uiudevelopershub.thinktanku.repository.quizresultrepo;

import com.uiudevelopershub.thinktanku.model.quizresult.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizResultRepo  extends JpaRepository<QuizResult, Long> {

    @Query("SELECT COUNT(q) FROM QuizResult q WHERE q.quizSessionId = :quizSessionId AND q.userId = :userId AND q.isCorrect = true")
    long countByQuizSessionIdAndUserIdAndIsCorrect(@Param("quizSessionId") Long quizSessionId, @Param("userId") Long userId);
}
