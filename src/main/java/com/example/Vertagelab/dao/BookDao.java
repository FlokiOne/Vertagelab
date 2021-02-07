package com.example.Vertagelab.dao;

import com.example.Vertagelab.model.Book;

import java.util.List;

public interface BookDao {

    String GET_ALL_BOOKS =
            "SELECT b.book_id bookId,\n" +
                    "       b.title title,\n" +
                    "       u.user_id userId,\n" +
                    "       u.first_name fName,\n" +
                    "       u.last_name lName,\n" +
                    "       b.status status\n" +
                    "FROM books b, users u\n" +
                    "WHERE u.user_id = b.user_id";

    String GET_BOOKS_FILTER_BY_STATUS =
            "SELECT b.book_id bookId, " +
                    "b.title title, " +
                    "u.user_id userId," +
                    "u.first_name fName," +
                    "u.last_name lName," +
                    "b.status status\n" +
            "FROM books b, users u\n" +
            "WHERE u.user_id = b.user_id " +
                    "AND b.status = ?";

    String GET_BOOKS_BY_USER_ID =
            "SELECT b.book_id bookId,\n" +
            "       b.title title,\n" +
            "       u.user_id userId,\n" +
            "       u.first_name fName,\n" +
            "       u.last_name lName,\n" +
            "       b.status status\n" +
            "FROM books b, users u\n" +
            "WHERE u.user_id = ?\n" +
            "  AND u.user_id = b.user_id";

    String GET_BOOK_BY_ID =
            "SELECT b.book_id bookId, " +
                    "b.title title," +
                    "u.user_id userId," +
                    "u.first_name fName," +
                    "u.last_name lName," +
                    "b.status status\n" +
            "FROM books b, users u\n" +
            "WHERE b.book_id = ?" +
            "AND u.user_id = b.user_id";

    String CREATE_NEW_BOOK =
            "INSERT INTO books (book_id, user_id, title, status) VALUES(BOOK_SEQ.nextval, ?, ?, ?)";

    String UPDATE_BOOK =
            "UPDATE books SET user_id = ?, title = ?, status = ? WHERE book_id = ?";

    String DELETE_BOOK =
            "DELETE FROM books WHERE book_id = ?";


    String EXCEPTION_GET_BOOK = "Couldn't find BOOK with id";
    String EXCEPTION_GET_BOOK_BY_USER_ID = "Couldn't find BOOK with this USER id";
    String EXCEPTION_GET_BOOK_BY_STATUS = "Couldn't find BOOK with this STATUS";
    String EXCEPTION_GET_ALL_BOOKS = "Failed to get any BOOK";
    String EXCEPTION_CREATE_BOOK = "Cant insert BOOK";
    String EXCEPTION_UPDATE_BOOK = "Cant update BOOK";
    String EXCEPTION_DELETE_BOOK = "Cant delete BOOK";


    List<Book> getAllBooks();

    List<Book> getBooksByUserId(Integer userId);

    List<Book> getBooksFilterByStatus(String status);

    Book getBookById(Integer bookId);

    void createNewBook(Book book);

    void updateBook(Book book);

    void deleteBook(Integer bookId);

}
