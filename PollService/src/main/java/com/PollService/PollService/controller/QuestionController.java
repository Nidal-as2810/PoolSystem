package com.PollService.PollService.controller;

import com.PollService.PollService.model.Question;
import com.PollService.PollService.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionService;

    @PostMapping(value = "/question/create")
    public void questionCreate(@RequestBody Question question){
        questionService.createQuestion(question);
    }

    @PutMapping(value = "/question/{questionId}/update")
    public void questionUpdate(@PathVariable Long questionId, @RequestBody Question question){
        questionService.updateQuestion(question);
    }

    @DeleteMapping(value = "/question/{questionId}/delete")
    public void questionDelet(@PathVariable Long questionId){
        questionService.DeleteQuestion(questionId);
    }

    @GetMapping(value = "/question/{questionId}")
    public Question getQuestionById(@PathVariable Long questionId){
        return questionService.getQuestionById(questionId);
    }

    @GetMapping(value = "/questions")
    public List<Question> getAllQuestions(){
        return questionService.getQuestionsList();
    }
}
