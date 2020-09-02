package platform.quizbank.representation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import platform.quizbank.application.QuizBankApplicationService;
import platform.quizbank.domain.mapper.BlankQuizMapper;
import platform.quizbank.domain.mapper.QuizBankMapper;
import platform.quizbank.representation.request.CreateBlankQuizRequest;
import platform.quizbank.representation.request.UpdateBlankQuizRequest;
import platform.quizbank.representation.response.BlankQuizResponse;
import platform.quizbank.representation.response.QuizBankResponse;

import java.util.List;

@RestController
@RequestMapping("/quizbank")
public class QuizBankController {

    private final QuizBankApplicationService quizBankApplicationService;

    @Autowired
    public QuizBankController(QuizBankApplicationService quizBankApplicationService) {
        this.quizBankApplicationService = quizBankApplicationService;
    }

    @GetMapping
    public QuizBankResponse getQuizBank() {
        return QuizBankMapper.INSTANCE.toQuizBankResponse(quizBankApplicationService.getQuizBank());
    }

    @GetMapping("/blank-quizzes")
    public List<BlankQuizResponse> getAllBlankQuizzes() {
        return BlankQuizMapper.INSTANCE.toBlankQuizResponseList(quizBankApplicationService.getAllQuizzes());
    }

    @GetMapping("/blank-quizzes/{quizId}")
    public BlankQuizResponse findBlankQuizzesById(@PathVariable("quizId") String quizId) {
        return BlankQuizMapper.INSTANCE.toBlankQuizResponse(quizBankApplicationService.findQuizById(quizId));
    }

    @PostMapping("/blank-quizzes")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public BlankQuizResponse createBlankQuiz(@RequestBody CreateBlankQuizRequest request) {
        return BlankQuizMapper.INSTANCE.toBlankQuizResponse(quizBankApplicationService.createBlankQuiz(request));
    }

    @PutMapping("/blank-quizzes/{quizId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateBlankQuiz(@PathVariable("quizId") String quizId,
                                @RequestBody UpdateBlankQuizRequest request) {
        quizBankApplicationService.updateBlankQuiz(quizId, request);
    }

    @DeleteMapping("/blank-quizzes/{quizId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteBlankQuiz(@PathVariable("quizId") String quizId) {
        quizBankApplicationService.deleteBlankQuiz(quizId);
    }
}
