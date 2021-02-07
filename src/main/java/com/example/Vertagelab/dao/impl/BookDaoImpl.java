package com.example.Vertagelab.dao.impl;

import com.example.Vertagelab.dao.BookDao;
import com.example.Vertagelab.dao.mapper.BookMapper;
import com.example.Vertagelab.exception.DaoAccessException;
import com.example.Vertagelab.model.Book;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
@Log4j
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Book> getAllBooks() throws DataAccessException {
        try {
            List<Book> list = jdbcTemplate.query(GET_ALL_BOOKS, new BookMapper());
            return list;
        } catch (DataAccessException e) {
            e = new DaoAccessException(EXCEPTION_GET_ALL_BOOKS, e.getCause());
            log.log(Level.ERROR, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Book> getBooksByUserId(Integer userId) throws DataAccessException {
        try {
            List<Book> list = jdbcTemplate.query(GET_BOOKS_BY_USER_ID, new BookMapper(), userId);
            return list;
        } catch (DataAccessException e) {
            e = new DaoAccessException(EXCEPTION_GET_BOOK_BY_USER_ID, e.getCause());
            log.log(Level.ERROR, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Book> getBooksFilterByStatus(String status) throws DataAccessException {
        try {
            return jdbcTemplate.query(GET_BOOKS_FILTER_BY_STATUS, new BookMapper(), status);
        } catch (DataAccessException e) {
            e = new DaoAccessException(EXCEPTION_GET_BOOK_BY_STATUS, e.getCause());
            log.log(Level.ERROR, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Book getBookById(Integer bookId) throws DataAccessException {
        try {
            return jdbcTemplate.queryForObject(GET_BOOK_BY_ID, new BookMapper(), bookId);
        } catch (DataAccessException e) {
            e = new DaoAccessException(EXCEPTION_GET_BOOK, e.getCause());
            log.log(Level.ERROR, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void createNewBook(Book book) {
        try {
            jdbcTemplate.update(CREATE_NEW_BOOK,
                    book.getBookId(),
                    book.getUser().getUserId(),
                    book.getTitle(),
                    book.getStatus());
        } catch (DataAccessException e) {
            e = new DaoAccessException(EXCEPTION_CREATE_BOOK, e.getCause());
            log.log(Level.ERROR, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void updateBook(Book book) {
        try {
            jdbcTemplate.update(UPDATE_BOOK,
                    book.getUser().getUserId(),
                    book.getTitle(),
                    book.getStatus().toString(),
                    book.getBookId());
        } catch (DataAccessException e) {
            e = new DaoAccessException(EXCEPTION_UPDATE_BOOK, e.getCause());
            log.log(Level.ERROR, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteBook(Integer bookId) {
        try {
            jdbcTemplate.update(DELETE_BOOK, bookId);
        } catch (DataAccessException e) {
            e = new DaoAccessException(EXCEPTION_DELETE_BOOK, e.getCause());
            log.log(Level.ERROR, e.getMessage(), e);
            throw e;
        }
    }
}
