package com.example.Vertagelab.dao;

import com.example.Vertagelab.model.User;

import java.math.BigInteger;
import java.util.List;

public interface UserDao {

    String addNewUser = "";

    String getAllUsers = "";

    String getUser = "";

    String updateStudent = "";

    String deleteStudent = "";


    void addNewUser(User user);

    List<User> getAllUsers();

    User getUser(BigInteger id);

    void updateStudent(User student);

    void deleteStudent(BigInteger id);

}
