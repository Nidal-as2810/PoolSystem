package com.PollService.PollService.model;

public class AnswerChosenToMap {
    private Long answerId;
    private Integer answeredCount;

    public AnswerChosenToMap(Long answerId, Integer answeredCount) {
        this.answerId = answerId;
        this.answeredCount = answeredCount;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Integer getAnsweredCount() {
        return answeredCount;
    }

    public void setAnsweredCount(Integer answeredCount) {
        this.answeredCount = answeredCount;
    }

}
