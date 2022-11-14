package com.PollService.PollService.controller;

import com.PollService.PollService.UserApi.UserService;
import com.PollService.PollService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value = "/person/{id}")
    User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
}
