package com.PollService.PollService.model;

import java.util.ArrayList;
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

    public QuestionAnswerResponse toQuestionAnswerResponse(Question question, List<Answer> answers){
        List<Answer> currentAnswers=new ArrayList<>();
        for(int i=0;i<4;i++){
            if (answers.size()>i){
                currentAnswers.add(answers.get(i));
            }else {
                currentAnswers.add(null);
            }
        }
        return new QuestionAnswerResponse(
                question,currentAnswers.get(0),currentAnswers.get(1),currentAnswers.get(2),currentAnswers.get(3)
        );
    }

}
