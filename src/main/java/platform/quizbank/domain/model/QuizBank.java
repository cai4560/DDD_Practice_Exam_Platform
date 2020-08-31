package platform.quizbank.domain.model;

import lombok.Getter;
import platform.quizbank.domain.Entity;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
public class QuizBank implements Entity<QuizBank> {

    private final QuizBankId id;

    private final Set<Quiz> quizSet;

    private final LocalDateTime createdTime;

    private final LocalDateTime updatedTime;

    private QuizBank(Set<Quiz> quizSet) {
        this.id = new QuizBankId();
        this.quizSet = quizSet;
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

    @Override
    public boolean sameIdentityAs(QuizBank other) {
        return equals(other);
    }

    public static QuizBank createQuizBank(Set<Quiz> quizSet) {
        return new QuizBank(quizSet);
    }
}
