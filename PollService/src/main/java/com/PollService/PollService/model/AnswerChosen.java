package com.PollService.PollService.model;

public class AnswerChosen {
    private String answerText;
    private Integer answerChosen;
    public AnswerChosen(String answerText, Integer answerChosen) {
        this.answerText = answerText;
        this.answerChosen = answerChosen;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Integer getAnswerChosen() {
        return answerChosen;
    }

    public void setAnswerChosen(Integer answerChosen) {
        this.answerChosen = answerChosen;
    }
}
