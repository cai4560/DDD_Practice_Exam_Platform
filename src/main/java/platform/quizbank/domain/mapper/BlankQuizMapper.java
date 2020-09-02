package platform.quizbank.domain.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import platform.quizbank.domain.model.BlankQuiz;
import platform.quizbank.representation.response.BlankQuizResponse;

import java.util.List;

@Mapper
public interface BlankQuizMapper {

    BlankQuizMapper INSTANCE = Mappers.getMapper(BlankQuizMapper.class);

    @Mapping(target = "id", ignore = true)
    BlankQuizResponse toBlankQuizResponse(BlankQuiz quiz);

    List<BlankQuizResponse> toBlankQuizResponseList(List<BlankQuiz> quizzes);

    @AfterMapping
    default void fillInResponse(BlankQuiz quiz, @MappingTarget BlankQuizResponse response) {
        response.setId(quiz.getId().toString());
    }
}


