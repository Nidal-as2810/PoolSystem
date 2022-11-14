package com.PollService.PollService.service;

import com.PollService.PollService.UserApi.UserService;
import com.PollService.PollService.model.RegisterMode;
import com.PollService.PollService.model.User;
import com.PollService.PollService.model.UserAnswerRequest;
import com.PollService.PollService.repository.UserQuestionAnswerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQuestionAnswerServiceImpl implements UserQuestionAnswerService{
    @Autowired
    UserQuestionAnswerRepositoryImpl userQuestionAnswerRepository;
    @Autowired
    UserService userService;

    @Override
    public void createQuestionAnswer(UserAnswerRequest userAnswerRequest) {
        User user=userService.getUserByEmail(userAnswerRequest.getEmail());
        if(user.getRegisterMode()== RegisterMode.REGISTERED){
            userQuestionAnswerRepository.createQuestionAnswer(userAnswerRequest.toUserQuestionAnswer(
                    user.getUserId(),
                    userAnswerRequest.getAnswer().getQuestionId(),
                    userAnswerRequest.getAnswer().getId()
            ));
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
}
