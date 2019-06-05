package com.codecool.onlineshop.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String permission;

    public User(int userId, String userName, String password, String perrmission){
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

    public String getPerrmission() {
        return permission;
    }

    public String userInput()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    List login()
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

