package platform.quizbank.domain.model;

import lombok.Getter;
import platform.quizbank.domain.service.UpdateQuizRequest;

@Getter
public abstract class Quiz {

    protected QuizId id;
    
    protected String name;

    protected Integer score;

    protected QuizType quizType;

    protected abstract void updateQuiz(UpdateQuizRequest request);
}
