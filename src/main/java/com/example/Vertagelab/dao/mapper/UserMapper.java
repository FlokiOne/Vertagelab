package com.example.Vertagelab.dao.mapper;

import com.example.Vertagelab.model.PojoBuilder.UserBuilder;
import com.example.Vertagelab.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new UserBuilder()
                .withUserId(new Integer(resultSet.getString("user_id")))
                .withFirstName(resultSet.getString("first_name"))
                .withLastName(resultSet.getString("last_name"))
                .build();

        return user;
    }
}
