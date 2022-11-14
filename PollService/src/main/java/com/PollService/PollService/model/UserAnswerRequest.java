package com.PollService.PollService.model;

public class UserAnswerRequest {
    private Long id;
    private String email;
    private QuestionAnswersRequest questionAnswersRequest;
    private Answer answer;

    public UserAnswerRequest(Long id, String email, QuestionAnswersRequest questionAnswersRequest, Answer answer) {
        this.id = id;
        this.email = email;
        this.questionAnswersRequest = questionAnswersRequest;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return new UserQuestionAnswer(this.id,userId,questionId,answerId);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
