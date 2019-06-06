package com.codecool.onlineshop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private int userId;
    private String userName;
    private String password;
    private int permission;
    private int isLogged;

    public int isLogged() {
        return isLogged;
    }

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

    public String userInput()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public List login()
    {
        String userLogin;
        String userPassword;
        List<String> userData = new ArrayList<>();

        System.out.print("Login: ");
        userLogin = userInput();
        userData.add(userLogin);

        System.out.print("Password: ");
        userPassword = userInput();
        userData.add(userPassword);

        return userData;
    }
}

