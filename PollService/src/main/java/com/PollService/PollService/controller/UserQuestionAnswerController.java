package com.PollService.PollService.controller;

import com.PollService.PollService.model.QuestionOptionChosenResponse;
import com.PollService.PollService.model.UserAnswerRequest;
import com.PollService.PollService.model.UserQuestionAnswerResponse;
import com.PollService.PollService.service.UserQuestionAnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user-answer")
public class UserQuestionAnswerController {
    @Autowired
    UserQuestionAnswerServiceImpl userQuestionAnswerService;

    @PostMapping(value = "/create")
    public void creatUserQuestionAnswer(@RequestBody UserAnswerRequest userAnswerRequest){
        userQuestionAnswerService.createQuestionAnswer(userAnswerRequest);
    }

    @PutMapping(value = "/update/{userAnswerId}")
    public void updateUserQuestionAnswer(@PathVariable Long userAnswerId,@RequestBody UserAnswerRequest userAnswerRequest){
        userQuestionAnswerService.updateQuestionAnswer(userAnswerRequest);
    }

    @DeleteMapping(value = "/delete/{userAnswerId}")
    public void deleteUserAnswerById(@PathVariable Long userAnswerId){
        userQuestionAnswerService.deleteQuestionAnswerById(userAnswerId);
    }

    @DeleteMapping(value = "/delete-answers/{userId}")
    public void deleteUserAnswersByUserId(@PathVariable Long userId){
        userQuestionAnswerService.deleteQuestionAnswerByUserId(userId);
    }

    @GetMapping(value = "/get-users-answered-number/{questionId}")
    public String getNumberOfUsersAnsweredQuestionByQuestionId(@PathVariable Long questionId){
        return userQuestionAnswerService.getUsersAnsweredCountByQuestionId(questionId)+" users have answered this question number "+questionId;
    }

    @GetMapping(value = "/answer-user-count/{questionId}")
    public QuestionOptionChosenResponse getUsersChoseAnswerByQuestionId(@PathVariable Long questionId){
        return userQuestionAnswerService.getUsersChoseAnswerByQuestionId(questionId);
    }

    @GetMapping(value = "/questions-number/{userId}")
    public String getNumberOfQuestionsUserAnsweredByUserId(@PathVariable Long userId){
        return "This user has answered "+userQuestionAnswerService.getNumberOfQuestionsUserAnswered(userId)+" questions.";
    }

    @GetMapping(value = "/all-questions-answers-counter")
    public List<QuestionOptionChosenResponse> getAllQuestionsAndAnswerSelectedCount(){
        return userQuestionAnswerService.getAllQuestionsAndAnswerSelectedCount();
    }

    @GetMapping(value = "/user-answers-all/{userId}")
    public List<UserQuestionAnswerResponse> getAllUserAnswers(@PathVariable Long userId){
        return userQuestionAnswerService.getAllUserAnswers(userId);
    }
}
