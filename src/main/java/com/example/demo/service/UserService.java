package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return  userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        return  userOptional.get();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

//    public User updateUser(User user){
//        return userRepository.
//    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

}
