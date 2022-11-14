package com.PollService.PollService.controller;

import com.PollService.PollService.model.UserAnswerRequest;
import com.PollService.PollService.service.UserQuestionAnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
