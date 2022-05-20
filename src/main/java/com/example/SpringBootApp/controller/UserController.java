package com.example.SpringBootApp.controller;

import com.example.SpringBootApp.model.User;
import com.example.SpringBootApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String welcomePage() {
        return "index";
    }

    @GetMapping("/users")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @GetMapping("users/addUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("users/addUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("users/editUser/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("users/editUser")
    public String editShow(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/users";
    }

    @PostMapping("users/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
