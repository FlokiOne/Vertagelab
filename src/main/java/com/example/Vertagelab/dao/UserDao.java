package com.example.Vertagelab.dao;

import com.example.Vertagelab.model.User;

import java.util.List;

public interface UserDao {

    String CREATE_NEW_USER =
            "INSERT INTO users (user_id, first_name, last_name) VALUES(USER_SEQ.nextval, ?, ?)";

    String GET_ALL_USER =
            "SELECT user_id, first_name, last_name " +
                    "FROM users";

    String GET_USER_BY_ID =
            "SELECT user_id, first_name, last_name " +
                    "FROM users " +
                    "WHERE user_id = ?";

    String UPDATE_USER =
            "UPDATE users SET first_name = ?, last_name = ? WHERE user_id = ?";

    String DELETE_USER =
            "DELETE FROM users WHERE user_id = ?";


    String EXCEPTION_GET_USER = "Couldn't find USER with id";
    String EXCEPTION_GET_ALL_USERS = "Failed to get any USER";
    String EXCEPTION_CREATE_USER = "Cant insert USER";
    String EXCEPTION_UPDATE_USER = "Cant update USER";
    String EXCEPTION_DELETE_USER = "Cant delete USER";


    List<User> getAllUsers();

    User getUser(Integer id);

    void createNewUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

}
