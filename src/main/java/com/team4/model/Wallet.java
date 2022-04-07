package com.team4.model;

import com.team4.config.SingletonConnection;

import java.sql.Connection;

public class Wallet {
<<<<<<< HEAD
    private int id_wallet;
    private String name_wallet;
    private CurrencyWallet currencyWallet;
    private UserWallet userWallet;
=======
    private int id;
    private String name;
>>>>>>> duong
    private double balance;
    private String description;
    private User user;
    private CurrencyWallet currencyWallet;


    public Wallet() {
    }

<<<<<<< HEAD
    public Wallet(String name_wallet, CurrencyWallet currencyWallet, UserWallet userWallet, double balance, String description) {
        this.name_wallet = name_wallet;
        this.currencyWallet = currencyWallet;
        this.userWallet = userWallet;
        this.balance = balance;
        this.description = description;
    }

    public Wallet(int id_wallet, String name_wallet, double balance, String description) {
        this.id_wallet = id_wallet;
        this.name_wallet = name_wallet;
=======
    public Wallet(String name, double balance, String description, User user, CurrencyWallet currencyWallet) {
        this.name = name;
>>>>>>> duong
        this.balance = balance;
        this.description = description;
        this.user = user;
        this.currencyWallet = currencyWallet;
    }

    public Wallet(int id, String name, double balance, String description, User user, CurrencyWallet currencyWallet) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.description = description;
        this.user = user;
        this.currencyWallet = currencyWallet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

<<<<<<< HEAD
=======
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

>>>>>>> duong
    public CurrencyWallet getCurrencyWallet() {
        return currencyWallet;
    }

    public void setCurrencyWallet(CurrencyWallet currencyWallet) {
        this.currencyWallet = currencyWallet;
    }

<<<<<<< HEAD
    public UserWallet getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(UserWallet userWallet) {
        this.userWallet = userWallet;
=======
    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", currencyWallet=" + currencyWallet +
                '}';
>>>>>>> duong
    }
}
