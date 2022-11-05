package com.PollService.PollService.service;

import com.PollService.PollService.model.Answer;
import com.PollService.PollService.model.Question;
import com.PollService.PollService.model.QuestionAnswerResponse;
import com.PollService.PollService.model.QuestionAnswersRequest;
import com.PollService.PollService.repository.QuestionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionRepositoryImpl questionRepository;
    @Autowired
    private AnswerServiceImpl answerService;
    @Override
    public QuestionAnswerResponse createQuestion(QuestionAnswersRequest questionAnswersRequest) {
        if(questionAnswersRequest.getQuestion()!=null){
            Long questionId =questionRepository.createQuestion(questionAnswersRequest.toQuestion(questionAnswersRequest.getQuestion()));
            ArrayList<Answer> answers=new ArrayList<>();
            if(questionAnswersRequest.getFirstAnswer()!=null)
                answers.add(answerService.createAnswer(questionAnswersRequest.toAnswer(questionAnswersRequest.getFirstAnswer(),questionId)));
            if(questionAnswersRequest.getSecondAnswer()!=null)
                answers.add(answerService.createAnswer(questionAnswersRequest.toAnswer(questionAnswersRequest.getSecondAnswer(),questionId)));
            if(questionAnswersRequest.getThirdAnswer()!=null)
                answers.add(answerService.createAnswer(questionAnswersRequest.toAnswer(questionAnswersRequest.getThirdAnswer(),questionId)));
            if(questionAnswersRequest.getFourthAnswer()!=null)
                answers.add(answerService.createAnswer(questionAnswersRequest.toAnswer(questionAnswersRequest.getFourthAnswer(),questionId)));

            Question question=questionRepository.getQuestionById(questionId);
            return question.toQuestionAnswerResponse(question,answers);
        }else{
            return null;
        }
    }

    @Override
    public Question updateQuestion(Question question) {
        questionRepository.updateQuestion(question);
        return questionRepository.getQuestionById(question.getId());
    }

    @Override
    public void DeleteQuestion(Long id) {
        questionRepository.DeleteQuestion(id);
    }

    @Override
    public QuestionAnswerResponse getQuestionById(Long id) {
        List<Answer>answers=answerService.getAnswersByQuestionId(id);
        Question question=questionRepository.getQuestionById(id);
        return question.toQuestionAnswerResponse(question,answers);
    }

    @Override
    public List<QuestionAnswerResponse> getQuestionsList() {
        List<QuestionAnswerResponse> responses=new ArrayList<>();
        List<Question> questions=questionRepository.getQuestionsList();

        for(int i=0;i<questions.size();i++){
            List<Answer>answers=answerService.getAnswersByQuestionId(questions.get(i).getId());
            responses.add(questions.get(i).toQuestionAnswerResponse(questions.get(i),answers));
        }
        return responses;
    }
}
