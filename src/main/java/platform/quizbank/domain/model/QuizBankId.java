package platform.quizbank.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import platform.quizbank.domain.ValueObject;

@Getter
@AllArgsConstructor
public class QuizBankId implements ValueObject<QuizBankId> {

    private final String id;

    public QuizBankId() {
        id = generateNextId();
    }

    @Override
    public boolean sameValueAs(QuizBankId other) {
        return equals(other);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
