package com.example.SpringBootApp.service;

import com.example.SpringBootApp.dao.UserDao;
import com.example.SpringBootApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> allUsers() {
        return userDao.findAll();
    }

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public void edit(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }
}
