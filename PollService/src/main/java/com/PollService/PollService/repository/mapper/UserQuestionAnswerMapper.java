package com.PollService.PollService.repository.mapper;

import com.PollService.PollService.model.UserQuestionAnswer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserQuestionAnswerMapper implements RowMapper<UserQuestionAnswer> {
    @Override
    public UserQuestionAnswer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserQuestionAnswer(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("question_id"),
                rs.getLong("answer_id")
        );
    }
}
