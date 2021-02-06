package com.example.Vertagelab.model;

import java.math.BigInteger;

import lombok.Data;

@Data
public class Book {

    public enum Status {
        Enabled("Enabled"),
        Disabled("Disabled");
        private final String statusCode;

        Status(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getStatusCode() {
            return this.statusCode;
        }
    }

    private BigInteger bookId;
    private String title;
    private String authorName;
    private User user;
    private Status status;

    public Book(BigInteger bookId, String title, String authorName, User user, Status status) {
        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
        this.user = user;
        this.status = status;
    }

    public Book() {

    }
}
