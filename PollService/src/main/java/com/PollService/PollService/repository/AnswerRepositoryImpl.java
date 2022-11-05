package com.PollService.PollService.repository;

import com.PollService.PollService.repository.mapper.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.PollService.PollService.model.Answer;

import java.util.List;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository{
    private static final String TABLE_NAME="answerTBL";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Long createAnswer(Answer answer) {
        String sql="Insert Into " + TABLE_NAME + "(answer, question_id) Values(?,?)";
        jdbcTemplate.update(sql,answer.getAnswer(),answer.getQuestionId());

        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateAnswer(Answer answer) {
        String sql="Update "+TABLE_NAME+" Set answer=? Where id=?";
        jdbcTemplate.update(sql,answer.getAnswer(),answer,answer.getId());
    }

    @Override
    public void deleteAnswer(Long id) {
        String sql="Delete From "+TABLE_NAME+" Where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public Answer getAnswerById(Long id) {
        String sql="Select * From "+TABLE_NAME+" Where id=?";
        try {
            return jdbcTemplate.queryForObject(sql,new AnswerMapper(),id);
        }catch (EmptyResultDataAccessException exception){
            System.out.println("Empty");
            return null;
        }
    }

    @Override
    public List<Answer> getAnswersByQuestionId(Long questionId) {
        String sql="Select * From "+TABLE_NAME+" Where question_id=?";
        try {
            return jdbcTemplate.query(sql,new AnswerMapper(),questionId);
        }catch (EmptyResultDataAccessException exception){
            System.out.println("Empty");
            return null;
        }
    }
}
