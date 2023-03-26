package com.example.demo.entity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "users_with_pass")
public class UserWithPass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    @Nonnull
    private String password;
    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    @Nullable
    private UserRole role;

    @Column(name = "date_of_create_user")
    private LocalDateTime dateOfCreateUser;

    public UserWithPass(){}

    public UserWithPass(String name, String login, String password, UserRole role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setLogin(String login){
        this.login=login;
    }

    public String getLogin(){
        return this.login;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setRole(UserRole role){
        this.role = role;
    }

    public UserRole getRole(){
        return this.role;
    }

    public void setDateOfCreateUser(LocalDateTime date){
        this.dateOfCreateUser = date;
    }

    public LocalDateTime getDateOfCreateUser(){
        return this.dateOfCreateUser;
    }

}
