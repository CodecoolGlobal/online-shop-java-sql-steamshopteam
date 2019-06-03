package com.codecool.onlineshop.model;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String perrmission;

    public User(int userId, String userName, String password, String perrmission){
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.perrmission = perrmission;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPerrmission() {
        return perrmission;
    }
}

