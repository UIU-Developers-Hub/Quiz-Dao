package com.uiudevelopershub.thinktanku.service.impl;


import com.uiudevelopershub.thinktanku.auth.repository.UserRepo;
import com.uiudevelopershub.thinktanku.dto.response.QuizResultResponseDto;
import com.uiudevelopershub.thinktanku.model.quiz.Quiz;
import com.uiudevelopershub.thinktanku.model.quizresult.QuizResult;
import com.uiudevelopershub.thinktanku.repository.quizRepo.QuizRepo;
import com.uiudevelopershub.thinktanku.repository.quizSessionRepo.QuizSessionRepo;
import com.uiudevelopershub.thinktanku.repository.quizresultrepo.QuizResultRepo;
import com.uiudevelopershub.thinktanku.service.QuizResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizResultServiceImpl implements QuizResultService {

    private final QuizResultRepo quizResultRepository;
    private final QuizRepo quizRepo;
    private final UserRepo userRepo;
    private final QuizSessionRepo quizSessionRepo;

//    @Autowired
//    public QuizResultServiceImpl(QuizResultRepo quizResultRepository,QuizRepo quizRepo) {
//        this.quizResultRepository = quizResultRepository;
//        this.quizRepo = quizRepo;
//    }

    @Transactional
    public void submitAnswer(Long userId, Long quizSessionId, Long questionId, String userAnswer) {
        boolean isCorrect = checkAnswer(questionId, userAnswer);

        QuizResult quizResult = new QuizResult();
        quizResult.setUser(userRepo.findById(userId).orElse(null));
        quizResult.setQuizSession(quizSessionRepo.findById(quizSessionId).orElse(null));
        quizResult.setQuiz(quizRepo.findById(questionId).orElse(null));
        quizResult.setIsCorrect(isCorrect);
        quizResult.setTime(LocalDateTime.now());
        quizResult.setUserAnswer(userAnswer);

        quizResultRepository.save(quizResult);
    }

    @Override
    public long countCorrectAnswers(Long quizSessionId) {
        return 0;
    }

    public long countCorrectAnswers(Long quizSessionId, Long userId) {
        return quizResultRepository.countByQuizSessionIdAndUserIdAndIsCorrect(quizSessionId, userId);
    }

    private boolean checkAnswer(Long questionId, String userAnswer) {
        String correctAnswer = getCorrectAnswerFromDB(questionId);
        return userAnswer.equals(correctAnswer);
    }

    private String getCorrectAnswerFromDB(Long questionId) {
       Quiz quiz= quizRepo.findById(questionId).get();
        return quiz.getQuestionAnswer();
    }

    public List<QuizResultResponseDto> getCorrectAnswerById(Long quizSessionId, Long userId) {
        return quizResultRepository.QuizSessionIdAndUserIdAndIsCorrect(quizSessionId, userId);
    }
}
