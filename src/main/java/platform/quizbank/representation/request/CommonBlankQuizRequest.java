package platform.quizbank.representation.request;

import lombok.Getter;

@Getter
public abstract class CommonBlankQuizRequest {

    protected String name;

    protected Integer score;

    protected String standardAnswer;
}
