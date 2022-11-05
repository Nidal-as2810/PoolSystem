package com.PollService.PollService.repository;

import com.PollService.PollService.model.Question;
import com.PollService.PollService.repository.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class QuestionRepositoryImpl implements  QuestionRepository{
    private static final String TABLE_NAME="questionTBL";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long createQuestion(Question question) {
        String sql="Insert Into " + TABLE_NAME + "(question) Values(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "ID" });
            ((PreparedStatement) ps).setString(1, question.getQuestion());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public Question updateQuestion(Question question) {
        String sql="Update "+TABLE_NAME+" Set question=? Where id=?";
        jdbcTemplate.update(sql,question.getQuestion(),question.getId());
        return null;
    }

    @Override
    public void DeleteQuestion(Long questionId) {
        String sql="Delete From "+TABLE_NAME+" Where id=?";
        jdbcTemplate.update(sql,questionId);
    }

    @Override
    public Question getQuestionById(Long id) {
        String sql="Select * From "+TABLE_NAME+" Where id=?";
        try {
            return jdbcTemplate.queryForObject(sql,new QuestionMapper(),id);
        }catch (EmptyResultDataAccessException exception){
            System.out.println("Empty");
            return null;
        }
    }

    @Override
    public List<Question> getQuestionsList() {
        String sql="Select * From "+TABLE_NAME;
        try {
            return jdbcTemplate.query(sql,new QuestionMapper());
        }catch (EmptyResultDataAccessException exception){
            return null;
        }
    }
}
