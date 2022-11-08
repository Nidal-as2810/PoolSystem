package com.PollUserService.PollUserService.repository;

import com.PollUserService.PollUserService.module.User;
import com.PollUserService.PollUserService.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private static final String TABLE_NAME="user";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User createUser(User user) {
        String sql="Insert Into "+TABLE_NAME+"(first_name,last_name,email,age,address,status,verification) " +
                "Values(?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge(),
                user.getAddress(),
                user.getRegisterMode().name(),
                user.getVerificationCode());
        Long userId=jdbcTemplate.queryForObject("Select Last_Insert_Id()",Long.class);
        return getUserById(userId);
    }

    @Override
    public User updateUser(User user) {
        String sql="Update "+TABLE_NAME+" Set first_name=?,last_name=?,email=?,age=?,address=?,status=? " +
                "Where id=?";

        jdbcTemplate.update(sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge(),
                user.getAddress(),
                user.getRegisterMode().name(),
                user.getUserId());
        return getUserById(user.getUserId());
    }

    @Override
    public void deleteUser(Long id) {
        String sql="Delete From "+TABLE_NAME+" Where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public User getUserById(Long id) {
        String sql="Select * From "+TABLE_NAME+" Where id=?";

        try {
            return jdbcTemplate.queryForObject(sql,new UserMapper(),id);
        }catch (EmptyResultDataAccessException exception){
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        String sql="Select * From "+TABLE_NAME+" Where email=?";

        try {
            return jdbcTemplate.queryForObject(sql,new UserMapper(),email);
        }catch (EmptyResultDataAccessException exception){
            return null;
        }
    }

    @Override
    public List<User> getUsers() {
        String sql="Select * From "+TABLE_NAME;

        try {
            return jdbcTemplate.query(sql,new UserMapper());
        }catch (EmptyResultDataAccessException exception){
            return null;
        }
    }

    @Override
    public List<User> getUsersByFirstName(String firstName) {
        String sql="Select * From "+TABLE_NAME+" Where first_name=?";

        try {
            return jdbcTemplate.query(sql,new UserMapper(),firstName);
        }catch (EmptyResultDataAccessException exception){
            return null;
        }
    }


}
