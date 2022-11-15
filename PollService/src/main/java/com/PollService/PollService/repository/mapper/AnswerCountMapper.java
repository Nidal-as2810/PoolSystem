package com.PollService.PollService.repository.mapper;

import com.PollService.PollService.model.AnswerChosenToMap;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerCountMapper implements RowMapper<AnswerChosenToMap> {
    @Override
    public AnswerChosenToMap mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AnswerChosenToMap(
                rs.getLong("answer_id"),
                rs.getInt("times_answered")
        );
    }
}
