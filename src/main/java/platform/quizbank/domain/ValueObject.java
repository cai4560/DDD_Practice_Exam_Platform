package platform.quizbank.domain;

public interface ValueObject<T> {
    boolean sameValueAs(T other);

    default String generateNextId() {
        //TODO Generate ID
        return "";
    }
}
