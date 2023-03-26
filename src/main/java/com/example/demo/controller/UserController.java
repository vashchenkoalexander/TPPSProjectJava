package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('USER')")
    public User getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("new")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("welcome")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getWelcomepage(){
        return "Hello app";
    }

}
