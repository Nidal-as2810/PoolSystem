package com.PollService.PollService.repository;

import com.PollService.PollService.model.Question;

import java.util.List;

public interface QuestionRepository {
    Long createQuestion (Question question);
    Question updateQuestion (Question question);
    void DeleteQuestion (Long id);

    Question getQuestionById(Long id);
    List<Question> getQuestionsList();
}
