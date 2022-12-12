package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tpps/v1/user/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("new")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
