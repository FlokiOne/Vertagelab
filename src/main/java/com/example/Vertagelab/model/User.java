package com.example.Vertagelab.model;

import java.math.BigInteger;
import java.util.List;
import lombok.Data;

@Data
public class User {

    private BigInteger userId;
    private String firstName;
    private String lastName;
    private List<Book> booksList;

    public User(BigInteger userId, String firstName, String lastName, List<Book> booksList) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.booksList = booksList;
    }

    public User() {

    }
}
