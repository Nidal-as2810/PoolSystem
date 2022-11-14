package com.PollService.PollService.repository;

import com.PollService.PollService.model.UserQuestionAnswer;

public interface UserQuestionAnswerRepository {
    void createQuestionAnswer(UserQuestionAnswer userQuestionAnswer);
    void updateQuestionAnswer(UserQuestionAnswer userQuestionAnswer);
    void deleteQuestionAnswer(Long id);
    void deleteQuestionAnswerByUserId(Long userId);

}
