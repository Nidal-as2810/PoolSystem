package com.PollUserService.PollUserService.service;

import com.PollUserService.PollUserService.module.User;
import com.PollUserService.PollUserService.module.UserRequestResponeModel;

import java.util.List;

public interface UserService {
    UserRequestResponeModel createUser(UserRequestResponeModel user);
    User updateUser(User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getUsers();
    List<User> getUsersByFirstName(String firstName);
}
