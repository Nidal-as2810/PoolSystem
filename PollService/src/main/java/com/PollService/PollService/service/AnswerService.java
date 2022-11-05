package com.PollService.PollService.service;

import com.PollService.PollService.model.Answer;

import java.util.List;

public interface AnswerService {
    Answer createAnswer (Answer answer);
    Answer updateAnswer (Answer answer);
    void deleteAnswer (Long id);
    Answer getAnswerById(Long id);
    List<Answer> getAnswersByQuestionId(Long questionId);
}
