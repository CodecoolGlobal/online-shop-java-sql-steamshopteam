package com.codecool.onlineshop.model;

public class User {
    private int userId;
    private String userName;
    private String password;
    private int permission;
    private int isLogged;

    public User(int userId, String userName, String password, int permission, int isLogged){
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.permission = permission;
        this.isLogged = isLogged;
    }
    public User(String userName, String password, int permission){
        this.userName = userName;
        this.password = password;
        this.permission = permission;
    }

    public User()
    {

    }

    public int isLogged() {
        return isLogged;
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

    public int getPermission() {
        return permission;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public void setIsLogged(int isLogged) {
        this.isLogged = isLogged;
    }
}

