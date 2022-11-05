package com.PollService.PollService.repository;

import com.PollService.PollService.model.Answer;

import java.util.List;

public interface AnswerRepository {
    Long createAnswer(Answer answer);
    void updateAnswer(Answer answer);
    void deleteAnswer(Long id);
    Answer getAnswerById(Long id);
    List<Answer> getAnswersByQuestionId(Long questionId);
}
