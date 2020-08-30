package platform.quizbank.domain;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
