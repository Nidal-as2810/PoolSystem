package com.PollService.PollService.service;

import com.PollService.PollService.model.UserAnswerRequest;

public interface UserQuestionAnswerService {
    void createQuestionAnswer(UserAnswerRequest userAnswerRequest);
    void updateQuestionAnswer(UserAnswerRequest userAnswerRequest);
    void deleteQuestionAnswerById(Long id);
    void deleteQuestionAnswerByUserId(Long userId);
}
