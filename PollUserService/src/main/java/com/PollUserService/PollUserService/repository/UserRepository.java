package com.PollUserService.PollUserService.repository;

import com.PollUserService.PollUserService.module.User;

import java.util.List;

public interface UserRepository {
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getUsers();
    List<User> getUsersByFirstName(String firstName);
}
