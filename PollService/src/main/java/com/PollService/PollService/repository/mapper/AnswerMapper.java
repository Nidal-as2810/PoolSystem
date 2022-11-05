package com.PollService.PollService.repository.mapper;

import com.PollService.PollService.model.Answer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerMapper implements RowMapper<Answer> {
    @Override
    public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Answer(rs.getLong("id"),
                          rs.getString("answer"),
                          rs.getLong("question_id"));
    }
}
