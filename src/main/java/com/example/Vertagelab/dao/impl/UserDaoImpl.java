package com.example.Vertagelab.dao.impl;

import com.example.Vertagelab.dao.UserDao;
import com.example.Vertagelab.dao.mapper.UserMapper;
import com.example.Vertagelab.exception.DaoAccessException;
import com.example.Vertagelab.model.User;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Log4j
@Transactional
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createNewUser(User user) {
        try {
            jdbcTemplate.update(CREATE_NEW_USER, user.getFirstName(), user.getLastName());
        } catch (DataAccessException e) {
            e = new DaoAccessException(EXCEPTION_CREATE_USER, e.getCause());
            log.log(Level.ERROR, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<User> getAllUsers() throws DataAccessException {
        try {
            List<User> list = jdbcTemplate.query(GET_ALL_USER, new UserMapper());
            return list;
        } catch (DataAccessException e) {
            e = new DaoAccessException(EXCEPTION_GET_ALL_USERS, e.getCause());
            log.log(Level.ERROR, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public User getUser(Integer id) {
        try {
            User user = jdbcTemplate.queryForObject(GET_USER_BY_ID, new UserMapper(), id);
            return user;
        } catch (DataAccessException e) {
            e = new DaoAccessException(EXCEPTION_GET_USER, e.getCause());
            log.log(Level.ERROR, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            jdbcTemplate.update(UPDATE_USER,
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUserId());
        } catch (DataAccessException e) {
            e = new DaoAccessException(EXCEPTION_UPDATE_USER, e.getCause());
            log.log(Level.ERROR, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteUser(Integer id) {
        try {
            jdbcTemplate.update(DELETE_USER, id);
        } catch (DataAccessException e) {
            e = new DaoAccessException(EXCEPTION_DELETE_USER, e.getCause());
            log.log(Level.ERROR, e.getMessage(), e);
            throw e;
        }
    }

}


