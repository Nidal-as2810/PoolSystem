package com.PollService.PollService.repository;

import com.PollService.PollService.model.AnswerChosenToMap;
import com.PollService.PollService.model.UserQuestionAnswer;

import java.util.List;

public interface UserQuestionAnswerRepository {
    void createQuestionAnswer(UserQuestionAnswer userQuestionAnswer);
    void updateQuestionAnswer(UserQuestionAnswer userQuestionAnswer);
    void deleteQuestionAnswer(Long id);
    void deleteQuestionAnswerByUserId(Long userId);
    Boolean checkIfUserAnsweredQuestionByUserIdAndQuestionId(Long userId,Long questionId);
    Integer getUsersAnsweredCountByQuestionId(Long questionId);
    List<AnswerChosenToMap> getUsersChoseQuestionOptionNumber(Long questionId);
    Integer getNumberOfQuestionsUserAnswered(Long userId);
    List<AnswerChosenToMap> getAllQuestionsAndAnswerSelectedCount(Long questionId);
    List<UserQuestionAnswer> getAllUserAnswers(Long userId);
}
