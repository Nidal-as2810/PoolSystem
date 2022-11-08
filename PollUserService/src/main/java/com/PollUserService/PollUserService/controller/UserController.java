package com.PollUserService.PollUserService.controller;

import com.PollUserService.PollUserService.module.User;
import com.PollUserService.PollUserService.module.UserRequestResponeModel;
import com.PollUserService.PollUserService.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/user/create")
    public UserRequestResponeModel createUser(@RequestBody UserRequestResponeModel userRequestResponeModel){
        return  userService.createUser(userRequestResponeModel);
    }

    @PutMapping(value = "/user/{userId}/update")
    public User updateUser(@PathVariable Long userId,@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "/user/{userId}/delete")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

    @GetMapping(value = "/user/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping(value = "/user")
    public User getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(value = "/users-list")
    public List<User> getUsersByFirstName(@RequestParam String firstName){
        return userService.getUsersByFirstName(firstName);
    }
}
