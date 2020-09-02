package platform.quizbank.infrastructure;

import org.springframework.stereotype.Component;
import platform.quizbank.domain.model.BlankQuiz;
import platform.quizbank.domain.model.BlankQuizId;
import platform.quizbank.domain.model.QuizBank;
import platform.quizbank.domain.repository.QuizBankRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MemoryQuizBankRepository implements QuizBankRepository {

    private static final String DEFAULT_NAME = "Quiz Bank";

    private final QuizBank quizBank = QuizBank.create(DEFAULT_NAME);

    @Override
    public QuizBank getQuizBank() {
        return this.quizBank;
    }

    @Override
    public List<BlankQuiz> getAllBlankQuizzes() {
        return quizBank.getQuizSet().stream()
                .filter(quiz -> !quiz.getIsDeleted())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BlankQuiz> findBlankQuizById(BlankQuizId id) {
        return quizBank.getQuizSet().stream()
                .filter(quiz -> quiz.getId().sameValueAs(id) && !quiz.getIsDeleted())
                .findFirst();
    }

    @Override
    public void createBlankQuiz(BlankQuiz quiz) {
        quizBank.getQuizSet().add(quiz);
    }

    @Override
    public void updateBlankQuiz(BlankQuiz updateQuiz) {
        Optional<BlankQuiz> optionalQuiz = quizBank.getQuizSet().stream()
                .filter(quiz -> quiz.getId().sameValueAs(quiz.getId()))
                .findFirst();

        if (optionalQuiz.isPresent()) {
            quizBank.getQuizSet().remove(optionalQuiz.get());
            quizBank.getQuizSet().add(updateQuiz);
        }
    }
}
