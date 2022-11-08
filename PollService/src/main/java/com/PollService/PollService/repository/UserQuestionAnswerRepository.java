package com.PollService.PollService.repository;

import com.PollService.PollService.model.UserQuestionAnswer;

public interface UserQuestionAnswerRepository {
    void createQuestionAnswer(UserQuestionAnswer userQuestionAnswer);
    void updateQuestionAnswer(UserQuestionAnswer userQuestionAnswer);
    void deleteQuestionAnswer(Long id);
    void deleteQusetionAnswerByUserId(Long userId);
    int usersAnsweredThisQuestionByQuestionId(Long questionId);
    UserQuestionAnswer questionAnswerByUserId(Long userId);

}
