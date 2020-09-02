package platform.quizbank.domain.model;

import lombok.Getter;
import platform.quizbank.domain.Entity;
import platform.quizbank.representation.request.UpdateBlankQuizRequest;

import java.time.LocalDateTime;

@Getter
public class BlankQuiz implements Entity<BlankQuiz> {

    private final BlankQuizId id;

    private String name;

    private Integer score;

    private String standardAnswer;

    private final LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private Boolean isDeleted;

    public BlankQuiz(String name, Integer score, String standardAnswer) {
        this.id = new BlankQuizId();
        this.name = name;
        this.score = score;
        this.standardAnswer = standardAnswer;
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
        isDeleted = false;
    }

    public static BlankQuiz create(String name, Integer score, String standardAnswer) {
        return new BlankQuiz(name, score, standardAnswer);
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return this.id.equals(other.id);
    }

    public void update(UpdateBlankQuizRequest request) {
        this.name = request.getName();
        this.score = request.getScore();
        this.standardAnswer = request.getStandardAnswer();
        this.updatedTime = LocalDateTime.now();
    }

    public void delete() {
        this.isDeleted = true;
        this.updatedTime = LocalDateTime.now();
    }
}
