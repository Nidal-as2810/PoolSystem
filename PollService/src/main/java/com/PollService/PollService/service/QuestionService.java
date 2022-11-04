package com.PollService.PollService.service;

import com.PollService.PollService.model.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion (Question question);
    Question updateQuestion (Question question);
    void DeleteQuestion (Long id);
    Question getQuestionById(Long id);
    List<Question> getQuestionsList();
}
