package com.PollService.PollService.service;

import com.PollService.PollService.model.Answer;
import com.PollService.PollService.model.Question;
import com.PollService.PollService.model.QuestionAnswerResponse;
import com.PollService.PollService.model.QuestionAnswersRequest;
import com.PollService.PollService.repository.QuestionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionRepositoryImpl questionRepository;
    @Autowired
    private AnswerServiceImpl answerService;
    @Override
    public QuestionAnswerResponse createQuestion(QuestionAnswersRequest questionAnswersRequest) {
        if(questionAnswersRequest.getQuestion()!=null){
            Long questionId =questionRepository.createQuestion(questionAnswersRequest.toQuestion(questionAnswersRequest.getQuestion()));
            ArrayList<Answer> answers=new ArrayList<>();
            if(questionAnswersRequest.getFirstAnswer()!=null)
                answers.add(answerService.createAnswer(questionAnswersRequest.toAnswer(questionAnswersRequest.getFirstAnswer(),questionId)));
            if(questionAnswersRequest.getSecondAnswer()!=null)
                answers.add(answerService.createAnswer(questionAnswersRequest.toAnswer(questionAnswersRequest.getSecondAnswer(),questionId)));
            if(questionAnswersRequest.getThirdAnswer()!=null)
                answers.add(answerService.createAnswer(questionAnswersRequest.toAnswer(questionAnswersRequest.getThirdAnswer(),questionId)));
            if(questionAnswersRequest.getFourthAnswer()!=null)
                answers.add(answerService.createAnswer(questionAnswersRequest.toAnswer(questionAnswersRequest.getFourthAnswer(),questionId)));

            Question question=questionRepository.getQuestionById(questionId);
            return question.toQuestionAnswerResponse(question,answers);
        }else{
            return null;
        }
    }

    @Override
    public Question updateQuestion(Question question) {
        questionRepository.updateQuestion(question);
        return questionRepository.getQuestionById(question.getId());
    }

    @Override
    public void DeleteQuestion(Long id) {
        questionRepository.DeleteQuestion(id);
    }

    @Override
    public QuestionAnswerResponse getQuestionById(Long id) {
        List<Answer>answers=answerService.getAnswersByQuestionId(id);
        Question question=questionRepository.getQuestionById(id);
        return question.toQuestionAnswerResponse(question,answers);
    }

    @Override
    public List<QuestionAnswerResponse> getQuestionsList() {
        List<QuestionAnswerResponse> responses=new ArrayList<>();
        List<Question> questions=questionRepository.getQuestionsList();
        if(questions.size()==0){
            List<QuestionAnswersRequest> list=createQuestionsAndAnswers();
            for(int i=0;i<list.size();i++){
                createQuestion(list.get(i));
            }
            getQuestionsList();
        }
        for(int i=0;i<questions.size();i++){
            List<Answer>answers=answerService.getAnswersByQuestionId(questions.get(i).getId());
            responses.add(questions.get(i).toQuestionAnswerResponse(questions.get(i),answers));
        }
        return responses;
    }

    private List<QuestionAnswersRequest> createQuestionsAndAnswers(){
        List<QuestionAnswersRequest> list=new ArrayList<>();

        Question question1=new Question(null,"If you had to listen to one album for the rest of your life, what would it be?");
        Answer answer1=new Answer(null,"Suicide",null);
        Answer answer2=new Answer(null,"Dónde Están los Ladrones",null);
        Answer answer3=new Answer(null,"Nick of Time",null);
        Answer answer4=new Answer(null,"Heart Like a Wheel",null);
        list.add(new QuestionAnswersRequest(question1,answer1,answer2,answer3,answer4));

        question1=new Question(null,"What's another language you wish you could speak fluently without studying?");
        answer1=new Answer(null,"Chinese",null);
        answer2=new Answer(null,"Ukrainian",null);
        answer3=new Answer(null,"Spanish",null);
        answer4=new Answer(null,"Japanese",null);
        list.add(new QuestionAnswersRequest(question1,answer1,answer2,answer3,answer4));

        question1=new Question(null,"What is your favorite flower?");
        answer1=new Answer(null,"Daisy",null);
        answer2=new Answer(null,"Apricot",null);
        answer3=new Answer(null,"Rose ",null);
        answer4=new Answer(null,"Orchid",null);
        list.add(new QuestionAnswersRequest(question1,answer1,answer2,answer3,answer4));

        question1=new Question(null,"Which mythical creature would make the best pet?");
        answer1=new Answer(null,"Dragon",null);
        answer2=new Answer(null,"Unicorn",null);
        answer3=new Answer(null,"Goblin",null);
        answer4=new Answer(null,"Sphinx",null);
        list.add(new QuestionAnswersRequest(question1,answer1,answer2,answer3,answer4));

        question1=new Question(null,"What wild animals suit you most?");
        answer1=new Answer(null,"Elephant",null);
        answer2=new Answer(null,"Tiger",null);
        answer3=new Answer(null,"Giraffe",null);
        answer4=new Answer(null,"whale",null);
        list.add(new QuestionAnswersRequest(question1,answer1,answer2,answer3,answer4));

        return list;
    }
}
