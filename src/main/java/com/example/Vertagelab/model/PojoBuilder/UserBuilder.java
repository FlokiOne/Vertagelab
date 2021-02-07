package com.example.Vertagelab.model.PojoBuilder;

import com.example.Vertagelab.model.Book;
import com.example.Vertagelab.model.User;

import java.util.List;

public class UserBuilder {

    private Integer userId;
    private String firstName;
    private String lastName;
    private List<Book> booksList;

    public UserBuilder withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withBooksList(List<Book> booksList) {
        this.booksList = booksList;
        return this;
    }

    public User build() {
        return new User(userId, firstName, lastName, booksList);
    }

}
