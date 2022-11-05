package com.PollService.PollService.service;

import com.PollService.PollService.model.Question;
import com.PollService.PollService.model.QuestionAnswerResponse;
import com.PollService.PollService.model.QuestionAnswersRequest;

import java.util.List;

public interface QuestionService {
    QuestionAnswerResponse createQuestion (QuestionAnswersRequest question);
    Question updateQuestion (Question question);
    void DeleteQuestion (Long id);
    QuestionAnswerResponse getQuestionById(Long id);
    List<QuestionAnswerResponse> getQuestionsList();
}
