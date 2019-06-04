package com.codecool.onlineshop.dao;

public class User {
    private int userId;
    private String userName;
    private String password;
    private int permission;

    public User(int userId, String userName, String password, int perrmission){
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.permission = perrmission;
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

    public int getPerrmission() {
        return permission;
    }

    public void login()
    {

    }
}

