package com.example.Vertagelab.dao.mapper;

import com.example.Vertagelab.model.Book;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.Vertagelab.model.PojoBuilder.BookBuilder;
import com.example.Vertagelab.model.PojoBuilder.UserBuilder;
import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new BookBuilder()
                .withBookId(new Integer(resultSet.getString("bookId")))
                .withTitle(resultSet.getString("title"))
                .withUser(new UserBuilder()
                        .withUserId(new Integer(resultSet.getString("userId")))
                        .withFirstName(resultSet.getString("fName"))
                        .withLastName(resultSet.getString("lName"))
                        .build())
                .withStatus(Book.Status.valueOf(resultSet.getString("status")))
                .build();

        return book;
    }
}
