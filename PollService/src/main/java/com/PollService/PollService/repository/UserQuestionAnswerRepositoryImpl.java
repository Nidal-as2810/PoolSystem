package com.PollService.PollService.repository;

import com.PollService.PollService.model.AnswerChosenToMap;
import com.PollService.PollService.model.UserQuestionAnswer;
import com.PollService.PollService.repository.mapper.AnswerCountMapper;
import com.PollService.PollService.repository.mapper.UserQuestionAnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserQuestionAnswerRepositoryImpl implements UserQuestionAnswerRepository{
    private static final String Table_Name="userAnswerTBL";
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void createQuestionAnswer(UserQuestionAnswer userQuestionAnswer) {
            String sql="Insert Into "+Table_Name+"(user_id, question_id,answer_id) Values(?,?,?)";
            jdbcTemplate.update(sql,
                    userQuestionAnswer.getUserId(),
                    userQuestionAnswer.getQuestionId(),
                    userQuestionAnswer.getAnswerId());
    }

    @Override
    public void updateQuestionAnswer(UserQuestionAnswer userQuestionAnswer) {
        String sql="Update "+Table_Name+" Set answer_id = ? Where id = ?";
        jdbcTemplate.update(sql,
                userQuestionAnswer.getAnswerId(),
                userQuestionAnswer.getId());
    }

    @Override
    public void deleteQuestionAnswer(Long id) {
        String sql="Delete From "+Table_Name+" Where id=?";
        jdbcTemplate.update(sql,
                id);
    }

    @Override
    public void deleteQuestionAnswerByUserId(Long userId) {
        String sql="Delete From "+Table_Name+" Where user_id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public Boolean checkIfUserAnsweredQuestionByUserIdAndQuestionId(Long userId, Long questionId) {
        String sql="Select * From "+Table_Name+" Where user_id=? And question_id=?";
        try{
            UserQuestionAnswer userQuestionAnswer=jdbcTemplate.queryForObject(sql,
                    new UserQuestionAnswerMapper(),
                    userId,
                    questionId);
            if(userQuestionAnswer!=null){
                return true;
            }
        }catch (Exception err){
            return false;
        }

        return false;
    }

    @Override
    public Integer getUsersAnsweredCountByQuestionId(Long questionId) {
        String sql="Select Count(id) From "+Table_Name+" Where question_id=?";

        return jdbcTemplate.queryForObject(sql,Integer.class,questionId);
    }

    @Override
    public List<AnswerChosenToMap> getUsersChoseQuestionOptionNumber(Long questionId) {
        String sql="Select question_id, answer_id, Count(answer_id) as times_answered From "+Table_Name+" Where question_id=? Group By answer_id";
        return jdbcTemplate.query(sql,new AnswerCountMapper(),questionId);
    }

    @Override
    public Integer getNumberOfQuestionsUserAnswered(Long userId) {
        String sql="Select Count(id) From "+Table_Name+" Where user_id=?";

        return jdbcTemplate.queryForObject(sql,Integer.class,userId);
    }

    @Override
    public List<AnswerChosenToMap> getAllQuestionsAndAnswerSelectedCount(Long questionId) {
        String sql="Select  answer_id, Count(answer_id) as times_answered From "+Table_Name+" Where question_id=? Group By answer_id";
        return jdbcTemplate.query(sql,new AnswerCountMapper(),questionId);
    }

    @Override
    public List<UserQuestionAnswer> getAllUserAnswers(Long userId) {
        String sql="Select * From "+Table_Name+" Where user_id=?";
        return jdbcTemplate.query(sql,new UserQuestionAnswerMapper(),userId);
    }

}
