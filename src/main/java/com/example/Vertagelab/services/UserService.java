package com.example.Vertagelab.services;

import com.example.Vertagelab.dao.BookDao;
import com.example.Vertagelab.dao.UserDao;
import com.example.Vertagelab.model.Book;
import com.example.Vertagelab.model.PojoBuilder.BookBuilder;
import com.example.Vertagelab.model.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UserService")
@Log4j
public class UserService {

    private final BookDao bookDao;

    private final UserDao userDao;

    @Autowired
    public UserService(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();

        for (User user : users) {
            Integer userId = user.getUserId();
            List<Book> books = new ArrayList<>();

            for (Book b : bookDao.getBooksByUserId(userId)) {
                books.add(getBookDTO(b));
            }

            user.setBooksList(books);
        }

        return users;
    }

    public User getUser(Integer id) {
        User user = userDao.getUser(id);

        List<Book> books = new ArrayList<>();
        for (Book b : bookDao.getBooksByUserId(id)) {
            books.add(getBookDTO(b));
        }

        user.setBooksList(books);

        return user;
    }

    public User createUser(User user) {
        userDao.createNewUser(user);

        return user;
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User deleteUser(Integer id) {
        User user = userDao.getUser(id);

        userDao.deleteUser(id);

        return user;
    }

    private Book getBookDTO(Book book) {
        return new BookBuilder()
                .withBookId(book.getBookId())
                .withTitle(book.getTitle())
                .withStatus(book.getStatus())
                .build();
    }

}
