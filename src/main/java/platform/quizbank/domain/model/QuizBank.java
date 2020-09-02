package platform.quizbank.domain.model;

import lombok.Getter;
import platform.quizbank.domain.Entity;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
public class QuizBank implements Entity<QuizBank> {

    private final QuizBankId id;

    private final String name;

    private final Set<BlankQuiz> quizSet;

    private final LocalDateTime createdTime;

    private final LocalDateTime updatedTime;

    private QuizBank(String name) {
        this.id = new QuizBankId();
        this.name = name;
        this.quizSet = Set.of();
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

    public static QuizBank create(String name) {
        return new QuizBank(name);
    }

    @Override
    public boolean sameIdentityAs(QuizBank other) {
        return equals(other);
    }
}
