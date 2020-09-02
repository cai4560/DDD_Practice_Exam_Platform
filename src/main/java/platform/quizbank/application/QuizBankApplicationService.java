package platform.quizbank.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.quizbank.domain.exception.NotFoundException;
import platform.quizbank.domain.model.BlankQuiz;
import platform.quizbank.domain.model.BlankQuizId;
import platform.quizbank.domain.model.QuizBank;
import platform.quizbank.domain.repository.QuizBankRepository;
import platform.quizbank.representation.request.CreateBlankQuizRequest;
import platform.quizbank.representation.request.UpdateBlankQuizRequest;

import java.util.List;

@Service
public class QuizBankApplicationService {

    private final QuizBankRepository repository;

    @Autowired
    public QuizBankApplicationService(QuizBankRepository repository) {
        this.repository = repository;
    }

    public QuizBank getQuizBank() {
        return repository.getQuizBank();
    }

    public List<BlankQuiz> getAllQuizzes() {
        return repository.getAllBlankQuizzes();
    }

    public BlankQuiz findQuizById(String quizId) {
        return repository.findBlankQuizById(new BlankQuizId(quizId))
                .orElseThrow(() -> new NotFoundException("Quiz id not found"));
    }

    public BlankQuiz createBlankQuiz(CreateBlankQuizRequest request) {
        BlankQuiz blankQuiz = BlankQuiz.create(request.getName(), request.getScore(), request.getStandardAnswer());
        repository.createBlankQuiz(blankQuiz);
        return blankQuiz;
    }

    public void updateBlankQuiz(String quizId, UpdateBlankQuizRequest request) {
        BlankQuiz quiz = findQuizById(quizId);
        quiz.update(request);
        repository.updateBlankQuiz(quiz);
    }

    public void deleteBlankQuiz(String quizId) {
        BlankQuiz quiz = findQuizById(quizId);
        quiz.delete();
        repository.updateBlankQuiz(quiz);
    }
}
