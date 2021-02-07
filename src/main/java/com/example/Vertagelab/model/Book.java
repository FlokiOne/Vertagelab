package com.example.Vertagelab.model;

import java.math.BigInteger;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Book {

    public enum Status {
        Enabled("Enabled"),
        Disabled("Disabled");
        private final String status;

        Status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return this.status;
        }
    }

    @Min(value = 0, message = "Book`s id is not correct")
    private Integer bookId;

    @Pattern(regexp = "^[а-яА-Яa-zA-Z]+(([',. -][а-яА-Яa-zA-Z ])?[а-яА-Яa-zA-Z]*)*$", message = "Title format is not correct")
    @NotEmpty(message = "Title can not be empty")
    @Size(min = 1, max = 255, message = "Title size is not correct. Character length must be between 1 and 255")
    private String title;

    private User user;
    private Status status;

    public Book(Integer bookId, String title, User user, Status status) {
        this.bookId = bookId;
        this.title = title;
        this.user = user;
        this.status = status;
    }

    public Book() {

    }
}
