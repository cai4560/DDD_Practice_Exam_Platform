package platform.quizbank.domain;

import java.util.UUID;

public interface ValueObject<T> {
    boolean sameValueAs(T other);

    default String generateNextId() {
        return UUID.randomUUID().toString();
    }
}
