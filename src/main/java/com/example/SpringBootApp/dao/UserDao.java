package com.example.SpringBootApp.dao;

import com.example.SpringBootApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDao extends JpaRepository<User, Long> {

}
