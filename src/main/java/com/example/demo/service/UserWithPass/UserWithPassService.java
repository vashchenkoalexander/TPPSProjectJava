package com.example.demo.service.UserWithPass;

import com.example.demo.entity.TypeOfCredit;
import com.example.demo.entity.UserRole;
import com.example.demo.entity.UserWithPass;
import com.example.demo.repository.ITypesOfCreditRepository;
import com.example.demo.repository.UserWithPassRepo.IUserWithPassRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserWithPassService {

    private final IUserWithPassRepository userWithPassRepository;
    private final ITypesOfCreditRepository typesOfCreditRepository;
    private final PasswordEncoder passwordEncoder;

    public UserWithPassService(IUserWithPassRepository userWithPassRepository, ITypesOfCreditRepository typesOfCreditRepository, PasswordEncoder passwordEncoder){
        this.userWithPassRepository = userWithPassRepository;
        this.typesOfCreditRepository = typesOfCreditRepository;
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
        userWithPass.setTypeOfCredit(userWithPass.getTypeOfCredit());

        return userWithPassRepository.save(userWithPass);
    }

    public UserWithPass updateUser(UserWithPass userWP, Long id){
        UserWithPass user = userWithPassRepository.findById(id).orElseGet(() -> userWithPassRepository.save(userWP));
        if(user.getDateOfCreateUser() == null){
            user.setDateOfCreateUser(LocalDateTime.now());
        }
        user.setTypeOfCredit(userWP.getTypeOfCredit());
        user.setName(userWP.getName());
        user.setRole(userWP.getRole());
        user.setLogin(userWP.getLogin());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userWithPassRepository.save(user);
    }

    public UserWithPass updateUserWithTypeOfCredit(UserWithPass userWP, Long id, Long TypeOfCreditId){
        TypeOfCredit typeOfCredit = typesOfCreditRepository.findById(TypeOfCreditId).orElseThrow(NullPointerException::new);
        TypeOfCredit newTypeOfCredit = new TypeOfCredit(typeOfCredit.getId(), typeOfCredit.getType_of_credit(), typeOfCredit.getLimitToCard());
        UserWithPass userWithPass = updateUser(userWP, id);
        userWithPass.setTypeOfCredit(newTypeOfCredit);
        return userWithPass;

    }

    public void deleteById(Long id){
        userWithPassRepository.deleteById(id);
    }



}
