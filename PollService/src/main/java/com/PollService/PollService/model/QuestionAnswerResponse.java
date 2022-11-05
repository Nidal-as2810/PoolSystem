package com.PollService.PollService.model;

public class QuestionAnswerResponse {
    private Question question;
    private Answer firstAnswer;
    private Answer secondAnswer;
    private Answer thirdAnswer;
    private Answer fourthAnswer;

    public QuestionAnswerResponse(Question question, Answer firstAnswer, Answer secondAnswer, Answer thirdAnswer, Answer fourthAnswer) {
        this.question = question;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(Answer firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public Answer getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(Answer secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public Answer getThirdAnswer() {
        return thirdAnswer;
    }

    public void setThirdAnswer(Answer thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    public Answer getFourthAnswer() {
        return fourthAnswer;
    }

    public void setFourthAnswer(Answer fourthAnswer) {
        this.fourthAnswer = fourthAnswer;
    }
}
