package com.PollService.PollService.model;

public class Answer {
    private Long id;
    private String answer;
    private Long questionId;

    public Answer(Long id, String answer, Long questionId) {
        this.id=id;
        this.answer = answer;
        this.questionId = questionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
