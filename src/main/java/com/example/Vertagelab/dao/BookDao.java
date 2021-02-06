package com.example.Vertagelab.dao;

import com.example.Vertagelab.model.Book;

import java.math.BigInteger;
import java.util.List;

public interface BookDao {

    String getAllBooks = "";

    String getBooksFilterByStatus = "";

    String getBooksByAuthor = "";

    String getBooksByUserId = "";

    String getBookById = "";

    String addNewBook = "";

    String updateBook = "";

    String deleteBook = "";


    List<Book> getAllBooks();

    List<Book> getBooksByUserId(BigInteger userId);

    List<Book> getBooksFilterByStatus(String status);

    List<Book> getBooksByAuthor(String authorName);

    Book getBookById(BigInteger bookId);

    void addNewBook(Book book);

    void updateBook(Book book);

    void deleteBook(BigInteger bookId);

}
