package platform.quizbank.domain.repository;

import platform.quizbank.domain.exception.NotFoundException;
import platform.quizbank.domain.model.Quiz;
import platform.quizbank.domain.model.QuizBank;
import platform.quizbank.domain.model.QuizBankId;
import platform.quizbank.domain.model.QuizId;
import platform.quizbank.domain.repository.QuizbankRepository;

import java.util.*;

public class MemoryQuizbankRepository implements QuizbankRepository {

    private final QuizBank quizBank = QuizBank.createQuizBank(Set.of());

    @Override
    public List<Quiz> findAllQuiz() {
        return new ArrayList<>(quizBank.getQuizSet());
    }

    @Override
    public Optional<Quiz> findQuizById(QuizId id) {
        return quizBank.getQuizSet().stream().filter(quiz -> quiz.getId().sameValueAs(id)).findFirst();
    }

    @Override
    public void addQuiz(Quiz quiz) {
        quizBank.getQuizSet().add(quiz);
    }

    @Override
    public void updateQuiz(Quiz updateQuiz) {
        Optional<Quiz> optionalQuiz = quizBank.getQuizSet().stream()
                .filter(quiz -> quiz.getId().sameValueAs(quiz.getId()))
                .findFirst();

        if (optionalQuiz.isEmpty()) {
            String message  = String.format("Quiz not found in Quiz Bank with id %s", updateQuiz.getId().toString());
            throw new NotFoundException(message);
        } else {
            quizBank.getQuizSet().remove(optionalQuiz.get());
            quizBank.getQuizSet().add(updateQuiz);
        }
    }

    @Override
    public void deleteQuiz(QuizId id) {
        Optional<Quiz> optionalQuiz = quizBank.getQuizSet().stream()
                .filter(quiz -> quiz.getId().sameValueAs(id))
                .findFirst();

        if (optionalQuiz.isEmpty()) {
            String message  = String.format("Quiz not found in Quiz Bank with id %s", id.toString());
            throw new NotFoundException(message);
        } else {
            quizBank.getQuizSet().remove(optionalQuiz.get());
        }
    }
}
