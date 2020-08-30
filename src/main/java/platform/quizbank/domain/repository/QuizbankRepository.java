package platform.quizbank.domain.repository;

import platform.quizbank.domain.model.Quiz;
import platform.quizbank.domain.model.QuizId;

import java.util.List;
import java.util.Optional;

public interface QuizbankRepository {

    void updateVersion(String version);

    List<Quiz> findAllQuiz();

    Optional<Quiz> findQuizById(QuizId id);

    void addQuiz(Quiz quiz);

    void updateQuiz(Quiz quiz);

    void deleteQuiz(Quiz quiz);
}
