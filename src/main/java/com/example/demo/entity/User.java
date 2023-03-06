package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "surr_Name")
    private String surrName;

//    @OneToMany(mappedBy = "user")//, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    //@JsonManagedReference
//    private List<TypesOfCredit> typesOfCredits;

    @OneToOne()
    @JoinColumn(name = "type_of_credit_id", referencedColumnName = "id")
    @JsonBackReference
    private TypeOfCredit typeOfCredit;

    @Column(name = "earn_Money_Per_Year")
    private int earnMoneyPerYear;
    @Column(name = "loans_history")
    private String loansHistory;
    @Column(name = "amount_Debit_Cards")
    private int amountDebitCards;
    @Column(name = "amount_Of_Saves")
    private int amountOfSaves;

    @Column(name = "user_role")
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    public User(){}

    public User(String firstName, String surrName, int earnMoneyPerYear, String loansHistory, int amountDebitCards, int amountOfSaves, UserRole userRole){
        this.firstName = firstName;
        this.surrName = surrName;
        this.earnMoneyPerYear = earnMoneyPerYear;
        this.loansHistory = loansHistory;
        this.amountDebitCards = amountDebitCards;
        this.amountOfSaves = amountOfSaves;
        this.userRole = userRole;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setSurrName(String surrName){
        this.surrName = surrName;
    }

    public String getSurrName(){
        return surrName;
    }

    public void setEarnMoneyPerYear(int earnMoneyPerYear){
        this.earnMoneyPerYear = earnMoneyPerYear;
    }

    public int getEarnMoneyPerYear(){
        return earnMoneyPerYear;
    }

    public void setLoansHistory(String loansHistory){
        this.loansHistory = loansHistory;
    }

    public String getLoansHistory(){
        return loansHistory;
    }

    public void setAmountDebitCards(int amountDebitCards){
        this.amountDebitCards = amountDebitCards;
    }

    public int getAmountDebitCards(){
        return amountDebitCards;
    }

    public void setAmountOfSaves(int amountOfSaves){
        this.amountOfSaves = amountOfSaves;
    }

    public int getAmountOfSaves(){
        return amountOfSaves;
    }

    public UserRole getUserRole(){
        return userRole;
    }

    public void setUserRole(UserRole userRole){
        this.userRole = userRole;
    }

}
