package com.PollService.PollService.model;

import java.util.List;

public class Question {
    private Long id;
    private String question;

    public Question(Long id,String question) {
        this.id=id;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
