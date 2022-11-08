package com.PollUserService.PollUserService.module;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String address;
    private RegisterMode registerMode;
    private LocalDateTime joinDate;
    private Integer verificationCode;

    public User(Long userId, String firstName, String lastName, String email, Integer age, String address, RegisterMode registerMode,LocalDateTime joinDate, Integer verificationCode) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.address = address;
        this.registerMode = registerMode;
        this.joinDate=joinDate;
        this.verificationCode=verificationCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RegisterMode getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(RegisterMode registerMode) {
        this.registerMode = registerMode;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(Integer verificationCode) {
        this.verificationCode = verificationCode;
    }
}
