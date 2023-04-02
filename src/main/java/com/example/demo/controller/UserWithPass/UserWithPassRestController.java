package com.example.demo.controller.UserWithPass;

import com.example.demo.entity.UserWithPass;
import com.example.demo.service.UserWithPass.UserWithPassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tpps/v1/userwithpass/")
public class UserWithPassRestController {

    private final UserWithPassService userWithPassService;

    public UserWithPassRestController(UserWithPassService userWithPassService) {
        this.userWithPassService = userWithPassService;
    }

    @GetMapping("all")
    public List<UserWithPass> getAllUsers(){
        return userWithPassService.getAllUsers();
    }

    @GetMapping("{id}")
    public UserWithPass getUserWithPassById(@PathVariable Long id){
        return userWithPassService.findById(id);
    }

    @PostMapping("new")
    public UserWithPass createUserWithPass(@RequestBody UserWithPass userWithPass){
        return userWithPassService.createUserWithPass(userWithPass);
    }

    @DeleteMapping("deleteby{id}")
    public void deleteUserWithPassById(@PathVariable Long id){
        userWithPassService.deleteById(id);
    }

    @PutMapping("updateuser{id}")
    public UserWithPass updateUser (@RequestBody UserWithPass userWithPass,@PathVariable Long id){

        return userWithPassService.updateUser(userWithPass, id);
    }

    @PutMapping("updateuser/{id}/withtypeofcredit/{typeOfCreditId}")
    public UserWithPass updateUserWithTypeOfCredit(@RequestBody UserWithPass userWithPass, @PathVariable Long id, @PathVariable Long typeOfCreditId){
        return userWithPassService.updateUserWithTypeOfCredit(userWithPass, id, typeOfCreditId);
    }



}
