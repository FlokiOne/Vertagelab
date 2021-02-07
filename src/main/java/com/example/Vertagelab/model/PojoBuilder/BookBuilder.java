package com.example.Vertagelab.model.PojoBuilder;

import com.example.Vertagelab.model.Book;
import com.example.Vertagelab.model.User;

public class BookBuilder {

    private Integer bookId;
    private String title;
    private User user;
    private Book.Status status;

    public BookBuilder withBookId(Integer bookId) {
        this.bookId = bookId;
        return this;
    }

    public BookBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public BookBuilder withStatus(Book.Status status) {
        this.status = status;
        return this;
    }

    public Book build() {
        return new Book(bookId, title, user, status);
    }

}
