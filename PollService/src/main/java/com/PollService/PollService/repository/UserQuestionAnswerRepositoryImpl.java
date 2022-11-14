package com.PollService.PollService.repository;

import com.PollService.PollService.model.UserQuestionAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
