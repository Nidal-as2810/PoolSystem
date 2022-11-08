package com.PollUserService.PollUserService.controller;

import com.PollUserService.PollUserService.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping(value = "/user/register")
    public String registration(@RequestParam String email, @RequestParam Integer verificationCode){
        return registerService.registration(email,verificationCode);
    }
}
