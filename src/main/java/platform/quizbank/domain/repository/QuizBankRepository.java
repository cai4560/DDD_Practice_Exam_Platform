package platform.quizbank.domain.repository;

import platform.quizbank.domain.model.BlankQuiz;
import platform.quizbank.domain.model.BlankQuizId;
import platform.quizbank.domain.model.QuizBank;

import java.util.List;
import java.util.Optional;

public interface QuizBankRepository {

    QuizBank getQuizBank();

    List<BlankQuiz> getAllBlankQuizzes();

    Optional<BlankQuiz> findBlankQuizById(BlankQuizId id);

    void createBlankQuiz(BlankQuiz quiz);

    void updateBlankQuiz(BlankQuiz quiz);
}
