package com.PollService.PollService.model;

import java.util.List;

public class QuestionOptionChosenResponse {
    private String questionText;
    List<AnswerChosen> answers;

    public QuestionOptionChosenResponse(String questionText, List<AnswerChosen> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<AnswerChosen> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerChosen> answers) {
        this.answers = answers;
    }
}
