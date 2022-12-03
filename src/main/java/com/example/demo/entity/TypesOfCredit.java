package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class TypesOfCredit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
//    @JsonBackReference
//    private User user;
}
