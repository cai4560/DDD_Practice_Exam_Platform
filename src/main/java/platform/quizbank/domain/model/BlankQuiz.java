package platform.quizbank.domain.model;

import lombok.Getter;
import platform.quizbank.domain.Entity;
import platform.quizbank.domain.service.UpdateQuizRequest;

@Getter
public class BlankQuiz extends Quiz implements Entity<BlankQuiz> {

    private final String standardAnswer;

    public BlankQuiz(String standardAnswer) {
        this.standardAnswer = standardAnswer;
        this.quizType = QuizType.BLANK_QUIZ;
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return this.id.equals(other.id);
    }

    @Override
    protected void updateQuiz(UpdateQuizRequest request) {
        this.name = request.getName();
        this.score = request.getScore();
    }
}
