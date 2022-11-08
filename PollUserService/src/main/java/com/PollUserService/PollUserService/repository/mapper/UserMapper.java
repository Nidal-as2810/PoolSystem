package com.PollUserService.PollUserService.repository.mapper;

import com.PollUserService.PollUserService.module.RegisterMode;
import com.PollUserService.PollUserService.module.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getInt("age"),
                rs.getString("address"),
                RegisterMode.valueOf(rs.getString("status")),
                rs.getTimestamp("join_date").toLocalDateTime(),
                rs.getInt("verification")
        );
    }
}
