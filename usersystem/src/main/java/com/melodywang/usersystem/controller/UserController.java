package com.melodywang.usersystem.controller;

import com.melodywang.usersystem.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.melodywang.usersystem.service.UserService;

@Controller
public class UserController {

    // Depend on UserService
    @Autowired
    @Qualifier("JpaUserService")
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String HelloWorld() {
        return "Hello Spring!";
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return user;
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestBody User input) {
        return userService.save(input);
    }

}

