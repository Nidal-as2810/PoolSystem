package com.PollService.PollService.controller;

import com.PollService.PollService.model.Question;
import com.PollService.PollService.model.QuestionAnswerResponse;
import com.PollService.PollService.model.QuestionAnswersRequest;
import com.PollService.PollService.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    QuestionServiceImpl questionService;

    @PostMapping(value = "/question/create")
    public QuestionAnswerResponse questionCreate(@RequestBody QuestionAnswersRequest questionAnswersRequest){
        return questionService.createQuestion(questionAnswersRequest);
    }

    @PutMapping(value = "/question/{questionId}/update")
    public Question questionUpdate(@PathVariable Long questionId, @RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    @DeleteMapping(value = "/question/{questionId}/delete")
    public void questionDelete(@PathVariable Long questionId){
        questionService.DeleteQuestion(questionId);
    }

    @GetMapping(value = "/question/{questionId}")
    public QuestionAnswerResponse getQuestionById(@PathVariable Long questionId){
        return questionService.getQuestionById(questionId);
    }

    @GetMapping(value = "/questions")
    public List<QuestionAnswerResponse> getAllQuestions(){
        return questionService.getQuestionsList();
    }
}
