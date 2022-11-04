package com.PollService.PollService.service;

import com.PollService.PollService.model.Question;
import com.PollService.PollService.repository.QuestionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionRepositoryImpl questionRepository;
    @Override
    public Question createQuestion(Question question) {
        questionRepository.createQuestion(question);
        return null;
    }

    @Override
    public Question updateQuestion(Question question) {
        questionRepository.updateQuestion(question);
        return null;
    }

    @Override
    public void DeleteQuestion(Long id) {
        questionRepository.DeleteQuestion(id);
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.getQuestionById(id);
    }

    @Override
    public List<Question> getQuestionsList() {
        return questionRepository.getQuestionsList();
    }
}
