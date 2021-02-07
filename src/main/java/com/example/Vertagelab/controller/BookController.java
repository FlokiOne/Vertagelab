package com.example.Vertagelab.controller;

import com.example.Vertagelab.exception.DaoAccessException;
import com.example.Vertagelab.model.Book;
import com.example.Vertagelab.model.PojoBuilder.BookBuilder;
import com.example.Vertagelab.model.PojoBuilder.UserBuilder;
import com.example.Vertagelab.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-info")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/get/{bookId}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable Integer bookId) throws DaoAccessException {
        Book book = bookService.getBookById(bookId);
        return book;
    }

    @RequestMapping(value = "/get-by-user/{userId}", method = RequestMethod.GET)
    public List<Book> getBookByUserId(@PathVariable Integer userId) throws DaoAccessException {
        List<Book> bookList = bookService.getBooksByUserId(userId);
        return bookList;
    }

    @RequestMapping(value = "/get-list", method = RequestMethod.GET)
    public List<Book> getAllBooks() throws DaoAccessException {
        List<Book> bookList = bookService.getAllBooks();
        return bookList;
    }

    @RequestMapping(value = "/get-by-status/{statusId}", method = RequestMethod.GET)
    public List<Book> getBooksFilterByStatus(@PathVariable Integer statusId) {
        List<Book> bookList = bookService.getBooksFilterByStatus(statusId);
        return bookList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public Book createNewBook(@RequestBody Book book) throws DaoAccessException {
        return bookService.createBook(book);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book book) throws DaoAccessException {

        bookService.updateBook(new BookBuilder()
                .withBookId(book.getBookId())
                .withTitle(book.getTitle())
                .withStatus(book.getStatus())
                .withUser(book.getUser())
                .build());

        return book;
    }

    @RequestMapping(value = "/delete/{bookId}", method = RequestMethod.PUT)
    public Book deleteBook(@PathVariable Integer bookId) throws DaoAccessException {
        return bookService.deleteBook(bookId);
    }

}
