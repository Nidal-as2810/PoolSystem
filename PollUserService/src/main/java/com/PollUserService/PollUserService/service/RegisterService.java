package com.PollUserService.PollUserService.service;

import com.PollUserService.PollUserService.module.RegisterMode;
import com.PollUserService.PollUserService.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    UserServiceImpl userService;

    public String registration(String email, Integer verificationCode){
        User user=userService.getUserByEmail(email);
        if(user!=null){
            Integer code=user.getVerificationCode();
            if(code.intValue()==verificationCode.intValue()){
                user.setRegisterMode(RegisterMode.REGISTERED);
                userService.updateUser(user);
                return "Mr/Mrs "+user.getLastName()+" "+ user.getFirstName()+",you have successfully verified your email.";
            }else {
                return "Wrong verification code, please check your inbox and try again.";
            }
        }else{
            return "This Email: "+email+", doesn't exist in our system.";
        }
    }
}
