package com.PollUserService.PollUserService.service;

import com.PollUserService.PollUserService.module.RegisterMode;
import com.PollUserService.PollUserService.module.User;
import com.PollUserService.PollUserService.module.UserRequestResponeModel;
import com.PollUserService.PollUserService.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepositoryImpl userRepository;
    @Autowired
    EmailVerificationService emailVerificationService;

    @Override
    public UserRequestResponeModel createUser(UserRequestResponeModel userRequestResponeModel) {
        User user=new User(null,userRequestResponeModel.getFirstName(),userRequestResponeModel.getLastName(),
                userRequestResponeModel.getEmail(),
                userRequestResponeModel.getAge(),
                userRequestResponeModel.getAddress(),
                RegisterMode.NOT_REGISTERED,
                null,
                (int) (Math.random()*1000000));
        emailVerificationService.sendEmail(user.getEmail(),"Your verification code is: "+user.getVerificationCode(), user.getFirstName());
        user=userRepository.createUser(user);
        return new UserRequestResponeModel(user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge(),
                user.getAddress());
    }

    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public List<User> getUsersByFirstName(String firstName) {
        return userRepository.getUsersByFirstName(firstName);
    }
}
