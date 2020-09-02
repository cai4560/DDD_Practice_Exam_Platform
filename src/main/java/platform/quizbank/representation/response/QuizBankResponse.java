package platform.quizbank.representation.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class QuizBankResponse {

    private String id;

    private String name;

    private Integer quizCount;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
