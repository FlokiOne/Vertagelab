package com.example.Vertagelab.controller;

import com.example.Vertagelab.exception.DaoAccessException;
import com.example.Vertagelab.model.PojoBuilder.UserBuilder;
import com.example.Vertagelab.model.User;
import com.example.Vertagelab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-info")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get/{userId}")
    public User getUserById(@PathVariable Integer userId) throws DaoAccessException {
        User user = userService.getUser(userId);
        return user;
    }

    @GetMapping("/get-list")
    public List<User> getAllUser() throws DaoAccessException {
        List<User> userList = userService.getAllUsers();
        return userList;
    }

    @PutMapping("/create")
    public User createUser(@RequestBody User user) throws DaoAccessException {
        return userService.createUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) throws DaoAccessException {

        userService.updateUser(new UserBuilder()
                .withLastName(user.getLastName())
                .withFirstName(user.getFirstName())
                .build());

        return user;
    }

    @PutMapping("/delete/{userId}")
    public User deleteUser(@PathVariable Integer userId) throws DaoAccessException {
        return userService.deleteUser(userId);
    }

}
