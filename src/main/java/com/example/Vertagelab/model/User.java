package com.example.Vertagelab.model;

import javax.validation.constraints.*;
import java.util.List;
import lombok.Data;

@Data
public class User {

    @Min(value = 1, message = "User`s id is not correct")
    private Integer userId;

    @Pattern(regexp = "^[а-яА-Яa-zA-Z]+(([',. -][а-яА-Яa-zA-Z ])?[а-яА-Яa-zA-Z]*)*$", message = "First name format is not correct")
    @NotEmpty(message = "First name can not be empty")
    @Size(min = 1, max = 255, message = "First name size is not correct. Character length must be between 1 and 255")
    private String firstName;

    @Pattern(regexp = "^[а-яА-Яa-zA-Z]+(([',. -][а-яА-Яa-zA-Z ])?[а-яА-Яa-zA-Z]*)*$", message = "Last name format is not correct")
    @NotEmpty(message = "Last name can not be empty")
    @Size(min = 1, max = 255, message = "Last name size is not correct. Character length must be between 1 and 255")
    private String lastName;

    private List<Book> booksList;

    public User(Integer userId, String firstName, String lastName, List<Book> booksList) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.booksList = booksList;
    }

    public User() {

    }
}
