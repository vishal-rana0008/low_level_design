package com.interview.interview1.model;

public class User {
    String userId;
    String name;
    String email;
    String password;
    double balance;

    public User(String userId, String name, String email, String password, double balance) {
        this.userId =
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void reduceBalance(double balance) {
        this.balance -= balance;
    }
}
