package com.PollService.PollService.service;

import com.PollService.PollService.model.*;

import java.util.List;

public interface UserQuestionAnswerService {
    void createQuestionAnswer(UserAnswerRequest userAnswerRequest);
    void updateQuestionAnswer(UserAnswerRequest userAnswerRequest);
    void deleteQuestionAnswerById(Long id);
    void deleteQuestionAnswerByUserId(Long userId);
    Boolean checkIfUserAnsweredQuestionByUserIdAndQuestionId(Long userId,Long questionId);
    Integer getUsersAnsweredCountByQuestionId(Long questionId);
    QuestionOptionChosenResponse getUsersChoseAnswerByQuestionId(Long questionId);
    Integer getNumberOfQuestionsUserAnswered(Long userId);
    List<QuestionOptionChosenResponse> getAllQuestionsAndAnswerSelectedCount();
    List<UserQuestionAnswerResponse> getAllUserAnswers(Long userId);
}
