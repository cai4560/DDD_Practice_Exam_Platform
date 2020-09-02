package platform.quizbank.domain.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import platform.quizbank.domain.model.QuizBank;
import platform.quizbank.representation.response.QuizBankResponse;

@Mapper
public interface QuizBankMapper {

    QuizBankMapper INSTANCE = Mappers.getMapper(QuizBankMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "quizCount", ignore = true)
    QuizBankResponse toQuizBankResponse(QuizBank entity);

    @AfterMapping
    default void fillInResponse(QuizBank quizBank, @MappingTarget QuizBankResponse response) {
        response.setId(quizBank.getId().toString());
        response.setQuizCount(quizBank.getQuizSet().size());
    }
}


