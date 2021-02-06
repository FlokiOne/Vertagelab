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
                .withBookId(new BigInteger(resultSet.getString("book_id")))
                .withAuthorName(resultSet.getString("author_name"))
                .withTitle(resultSet.getString("book_name"))
                .withUser(new UserBuilder()
                        .withUserId(new BigInteger(resultSet.getString("user_id")))
                        .withFirstName(resultSet.getString("first_name"))
                        .withLastName(resultSet.getString("last_name"))
                        .build())
                .withStatus(Book.Status.valueOf(resultSet.getString("book_status")))
                .build();

        return book;
    }
}
