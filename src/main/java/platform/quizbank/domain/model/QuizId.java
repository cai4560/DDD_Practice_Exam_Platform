package platform.quizbank.domain.model;

import platform.quizbank.domain.ValueObject;

public class QuizId implements ValueObject<QuizId> {

    private String id;

    @Override
    public boolean sameValueAs(QuizId other) {
        return equals(other);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
