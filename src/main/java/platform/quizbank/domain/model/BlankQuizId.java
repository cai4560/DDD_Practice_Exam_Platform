package platform.quizbank.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import platform.quizbank.domain.ValueObject;

@Getter
@AllArgsConstructor
public class BlankQuizId implements ValueObject<BlankQuizId> {

    private final String id;

    public BlankQuizId() {
        this.id = generateNextId();
    }

    @Override
    public boolean sameValueAs(BlankQuizId other) {
        return equals(other);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
