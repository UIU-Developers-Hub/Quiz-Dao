package com.uiudevelopershub.thinktanku.repository.quizRepo;

import com.uiudevelopershub.thinktanku.model.quiz.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {

    @Query("SELECT q FROM Quiz q ORDER BY q.questionTitle ASC")
    Page<Quiz> findAllWithPaginationOrdered(Pageable pageable);
}
