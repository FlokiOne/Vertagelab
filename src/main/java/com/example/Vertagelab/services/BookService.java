package com.example.Vertagelab.services;

import com.example.Vertagelab.dao.BookDao;
import com.example.Vertagelab.dao.UserDao;
import com.example.Vertagelab.exception.DaoAccessException;
import com.example.Vertagelab.exception.IncorrectArgumentException;
import com.example.Vertagelab.model.Book;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
@Log4j
public class BookService {

    private final BookDao bookDao;

    private final UserDao userDao;

    @Autowired
    public BookService(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public List<Book> getBooksByUserId(Integer userId) {
        return bookDao.getBooksByUserId(userId);
    }

    public List<Book> getBooksFilterByStatus(Integer statusId) {

        Book.Status status;

        if (statusId.equals(0)) {
            status = Book.Status.Enabled;
        } else if (statusId.equals(1)) {
            status = Book.Status.Disabled;
        } else {
            throw new IncorrectArgumentException("Status was incorrect");
        }

        return bookDao.getBooksFilterByStatus(status.toString());
    }

    public Book getBookById(Integer bookId) {
        return bookDao.getBookById(bookId);
    }

    public Book deleteBook(Integer bookId) {
        Book book = bookDao.getBookById(bookId);

        bookDao.deleteBook(bookId);

        return book;
    }

    public Book createBook(Book book) throws DaoAccessException {

        bookDao.createNewBook(book);

        return book;
    }

    public void updateBook(Book book) throws DaoAccessException {

      if (book.getUser().getUserId() == 0) {
            book.setStatus(Book.Status.Enabled);
        } else {
            book.setStatus(Book.Status.Disabled);
        }

       // book.setStatus(Book.Status.Enabled);
        bookDao.updateBook(book);
    }


}
