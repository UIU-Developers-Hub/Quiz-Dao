package com.uiudevelopershub.thinktanku.repository.quizresultrepo;

import com.uiudevelopershub.thinktanku.model.quizresult.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizResultRepo  extends JpaRepository<QuizResult, Long> {

}
