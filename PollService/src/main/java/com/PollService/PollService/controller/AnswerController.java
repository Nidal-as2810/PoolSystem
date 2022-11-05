package com.PollService.PollService.controller;

import com.PollService.PollService.model.Answer;
import com.PollService.PollService.service.AnswerService;
import com.PollService.PollService.service.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    private AnswerServiceImpl answerService;

    @PostMapping(value = "/answer/create")
    public Answer createAnswer(@RequestBody Answer answer){
        return answerService.createAnswer(answer);
    }

    @PutMapping(value = "/answer/{answerId}/update")
    public Answer updateAnswer(@RequestBody Answer answer, @PathVariable Long answerId){
        return answerService.updateAnswer(answer);
    }

    @DeleteMapping(value = "/answer/{answerId}/delete")
    public void deleteAnswer(@PathVariable Long answerId){
        answerService.deleteAnswer(answerId);
    }

    @GetMapping(value = "/answer/{answerId}")
    public Answer getAnswerById(@PathVariable Long answerId){
        return answerService.getAnswerById(answerId);
    }

    @GetMapping(value = "/answers/{questionId}")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long questionId){
        return answerService.getAnswersByQuestionId(questionId);
    }
}
