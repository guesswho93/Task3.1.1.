package com.example.SpringBootApp.service;

import com.example.SpringBootApp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService  {
    List<User> allUsers();
    void add(User user);
    void delete(Long id);
    void edit(User user);
    User getById(Long id);
}
