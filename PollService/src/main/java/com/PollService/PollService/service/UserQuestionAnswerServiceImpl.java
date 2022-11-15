package com.PollService.PollService.service;

import com.PollService.PollService.UserApi.UserService;
import com.PollService.PollService.model.*;
import com.PollService.PollService.repository.UserQuestionAnswerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserQuestionAnswerServiceImpl implements UserQuestionAnswerService{
    @Autowired
    UserQuestionAnswerRepositoryImpl userQuestionAnswerRepository;
    @Autowired
    UserService userService;
    @Autowired
    QuestionServiceImpl questionService;
    @Autowired
    AnswerServiceImpl answerService;

    @Override
    public void createQuestionAnswer(UserAnswerRequest userAnswerRequest) {
        User user=userService.getUserByEmail(userAnswerRequest.getEmail());

        if(!checkIfUserAnsweredQuestionByUserIdAndQuestionId(user.getUserId(),userAnswerRequest.getQuestionAnswersRequest().getQuestion().getId())) {
            if (user.getRegisterMode() == RegisterMode.REGISTERED) {
                userQuestionAnswerRepository.createQuestionAnswer(userAnswerRequest.toUserQuestionAnswer(
                        user.getUserId(),
                        userAnswerRequest.getQuestionAnswersRequest().getQuestion().getId(),
                        userAnswerRequest.getAnswer().getId()
                ));
            }
        }
    }

    @Override
    public void updateQuestionAnswer(UserAnswerRequest userAnswerRequest) {
        User user=userService.getUserByEmail(userAnswerRequest.getEmail());
        userQuestionAnswerRepository.updateQuestionAnswer(userAnswerRequest.toUserQuestionAnswer(
                user.getUserId(),
                userAnswerRequest.getAnswer().getQuestionId(),
                userAnswerRequest.getAnswer().getId()
        ));
    }

    @Override
    public void deleteQuestionAnswerById(Long id) {
        userQuestionAnswerRepository.deleteQuestionAnswer(id);
    }

    @Override
    public void deleteQuestionAnswerByUserId(Long userId) {
        userQuestionAnswerRepository.deleteQuestionAnswerByUserId(userId);
    }

    @Override
    public Boolean checkIfUserAnsweredQuestionByUserIdAndQuestionId(Long userId, Long questionId) {
        return userQuestionAnswerRepository.checkIfUserAnsweredQuestionByUserIdAndQuestionId(userId,questionId);
    }

    @Override
    public Integer getUsersAnsweredCountByQuestionId(Long questionId) {
        return userQuestionAnswerRepository.getUsersAnsweredCountByQuestionId(questionId);
    }

    @Override
    public QuestionOptionChosenResponse getUsersChoseAnswerByQuestionId(Long questionId) {

        List<AnswerChosenToMap> answerChosenToMaps= userQuestionAnswerRepository.getUsersChoseQuestionOptionNumber(questionId);
        QuestionAnswerResponse question= questionService.getQuestionById(questionId);
        String questionText=question.getQuestion().getQuestion();
        List<AnswerChosen> answers=new ArrayList<>();
        answers.add(new AnswerChosen(question.getFirstAnswer().getAnswer(),0));
        answers.add(new AnswerChosen(question.getSecondAnswer().getAnswer(),0));
        answers.add(new AnswerChosen(question.getThirdAnswer().getAnswer(),0));
        answers.add(new AnswerChosen(question.getFourthAnswer().getAnswer(),0));

        for(int i=0;i<answerChosenToMaps.size();i++){
            Answer answer=answerService.getAnswerById(answerChosenToMaps.get(i).getAnswerId());
            for(int x=0;x<answers.size();x++){
                if(answers.get(x).getAnswerText()==answer.getAnswer()){
                    answers.get(x).setAnswerChosen(answerChosenToMaps.get(i).getAnsweredCount());
                }
            }
        }
        return new QuestionOptionChosenResponse(questionText,answers);
    }

    @Override
    public Integer getNumberOfQuestionsUserAnswered(Long userId) {
        return userQuestionAnswerRepository.getNumberOfQuestionsUserAnswered(userId);
    }

    @Override
    public List<QuestionOptionChosenResponse> getAllQuestionsAndAnswerSelectedCount() {
        List<QuestionAnswerResponse> questions=questionService.getQuestionsList();
        List<QuestionOptionChosenResponse> questionsResponse=new ArrayList<>();

        for (var question:questions) {
            try {
                QuestionOptionChosenResponse response= getUsersChoseAnswerByQuestionId(question.getQuestion().getId());
                questionsResponse.add(response);
            }catch (Exception err){

            }
        }
        return questionsResponse;
    }

    @Override
    public List<UserQuestionAnswerResponse> getAllUserAnswers(Long userId) {
        List<UserQuestionAnswerResponse> responseList=new ArrayList<>();
        List<UserQuestionAnswer> list=userQuestionAnswerRepository.getAllUserAnswers(userId);

        for(var questionAnswer:list){
            String question=questionService.getQuestionById(questionAnswer.getQuestionId()).getQuestion().getQuestion();
            String answer=answerService.getAnswerById(questionAnswer.getAnswerId()).getAnswer();
            responseList.add(new UserQuestionAnswerResponse(question,answer));
        }
        return responseList;
    }
}
