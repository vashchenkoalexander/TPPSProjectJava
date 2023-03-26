package com.example.demo.service.UserWithPass;

import com.example.demo.entity.UserRole;
import com.example.demo.entity.UserWithPass;
import com.example.demo.repository.UserWithPassRepo.IUserWithPassRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserWithPassService {

    private  IUserWithPassRepository userWithPassRepository;
    private PasswordEncoder passwordEncoder;

    public UserWithPassService(IUserWithPassRepository userWithPassRepository, PasswordEncoder passwordEncoder){
        this.userWithPassRepository = userWithPassRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserWithPass> getAllUsers(){
        return userWithPassRepository.findAll();
    }

    public UserWithPass findById(Long id){
        Optional<UserWithPass> userWithPass = userWithPassRepository.findById(id);
        return userWithPass.orElse(null); // TODO will be good to add a THROWABLE EXCEPTION
    }

    public UserWithPass createUserWithPass(UserWithPass userWithPass){
        userWithPass.setPassword(passwordEncoder.encode(userWithPass.getPassword()));
        if(userWithPass.getRole() != null){
            switch (userWithPass.getRole()){
                case USER -> userWithPass.setRole(UserRole.USER);
                case MODERATOR -> userWithPass.setRole(UserRole.MODERATOR);
                case ADMIN -> userWithPass.setRole(UserRole.ADMIN);
                default -> userWithPass.setRole(null);
            }
        }
        System.out.println(userWithPass.getRole());
        userWithPass.setDateOfCreateUser(LocalDateTime.now());

        return userWithPassRepository.save(userWithPass);
    }

//    public UserWithPass updateUser(UserWithPass userWP){
//        return userWithPassRepository.
//    }

    public void deleteById(Long id){
        userWithPassRepository.deleteById(id);
    }



}
