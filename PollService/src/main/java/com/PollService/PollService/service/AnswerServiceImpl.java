package com.PollService.PollService.service;

import com.PollService.PollService.model.Answer;
import com.PollService.PollService.repository.AnswerRepository;
import com.PollService.PollService.repository.AnswerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    private AnswerRepositoryImpl answerRepository;

    @Override
    public Answer createAnswer(Answer answer) {
        return getAnswerById(answerRepository.createAnswer(answer));
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        answerRepository.updateAnswer(answer);
        return getAnswerById(answer.getId());
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteAnswer(id);
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.getAnswerById(id);
    }

    @Override
    public List<Answer> getAnswersByQuestionId(Long questionId) {
        return answerRepository.getAnswersByQuestionId(questionId);
    }
}
