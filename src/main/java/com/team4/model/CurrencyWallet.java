package com.team4.model;

public class CurrencyWallet {
    private int id;
    private String name;
    private Wallet wallet;

    public CurrencyWallet() {
    }

    public CurrencyWallet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CurrencyWallet(int id) {
        this.id = id;
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

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
