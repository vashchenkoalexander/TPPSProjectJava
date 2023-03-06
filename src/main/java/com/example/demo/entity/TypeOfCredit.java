package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;



@Entity
public class TypeOfCredit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String type_of_credit;

    @Column
    private int limitToCard;

//    @ManyToOne
//    @JoinColumn(name="user_id", nullable=false)
//    private User user;

    @OneToOne(mappedBy = "typeOfCredit")
    @JsonBackReference
    private User user;

    public TypeOfCredit(){}

    public TypeOfCredit(String type_of_credit, int limitToCard){
        this.type_of_credit = type_of_credit;
        this.limitToCard = limitToCard;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getType_of_credit(){
        return type_of_credit;
    }

    public void setType_of_credit(String type_of_credit){
        this.type_of_credit = type_of_credit;
    }

    public int getLimitToCard(){
        return limitToCard;
    }

    public void setLimitToCard(int limitToCard){
        this.limitToCard = limitToCard;
    }



}
