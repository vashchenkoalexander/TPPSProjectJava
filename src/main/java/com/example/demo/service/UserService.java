package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final IUserRepository userRepository;

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
        if( user.getUserRole() != null){
            switch (user.getUserRole()){
                case USER:
                    user.setUserRole(UserRole.USER);
                break;
                case ADMIN:
                    user.setUserRole(UserRole.ADMIN);
                    break;
                case MODERATOR:
                    user.setUserRole(UserRole.MODERATOR);
                    break;
                default:
                    user.setUserRole(null);
            }
        } else {
            user.setUserRole(null);
        }

        return userRepository.save(user);
    }

//    public User updateUser(User user){
//        return userRepository.
//    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

}
