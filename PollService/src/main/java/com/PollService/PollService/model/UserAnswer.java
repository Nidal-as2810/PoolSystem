package com.PollService.PollService.model;

public class UserAnswer {
    private Long id;
    private User user;
    private QuestionAnswersRequest questionAnswersRequest;
    private Answer answer;

    public UserAnswer(Long id, User user, QuestionAnswersRequest questionAnswersRequest, Answer answer) {
        this.id = id;
        this.user = user;
        this.questionAnswersRequest = questionAnswersRequest;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public QuestionAnswersRequest getQuestionAnswersRequest() {
        return questionAnswersRequest;
    }

    public void setQuestionAnswersRequest(QuestionAnswersRequest questionAnswersRequest) {
        this.questionAnswersRequest = questionAnswersRequest;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public UserQuestionAnswer toUserQuestionAnswer(Long userId,Long questionId,Long answerId){
        return new UserQuestionAnswer(null,userId,questionId,answerId);
    }
}
