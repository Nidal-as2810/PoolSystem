package com.PollUserService.PollUserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailVerificationService {
    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(String toEmail, String body, String name){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("Nidal");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject("Verification Code");

        javaMailSender.send(message);
        return "Dear "+ name +"; \n" +
                "check your email inbox to verify your account!";
    }
}
