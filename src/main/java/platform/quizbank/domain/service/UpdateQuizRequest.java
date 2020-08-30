package platform.quizbank.domain.service;

import lombok.Getter;
import platform.quizbank.domain.model.QuizId;

@Getter
public class UpdateQuizRequest {

    private QuizId quizId;

    private String name;

    private Integer score;
}
