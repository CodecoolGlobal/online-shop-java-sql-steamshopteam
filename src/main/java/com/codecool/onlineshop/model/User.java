package com.codecool.onlineshop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private int userId;
    private String userName;
    private String password;
    private int permission;

    UserInput input = new UserInput();

    public User(int userId, String userName, String password, int permission){
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.permission = permission;
    }

    public User()
    {

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



    public List login()
    {
        String userLogin;
        String userPassword;
        List<String> userData = new ArrayList<>();

        System.out.print("Login: ");
        userLogin = input.input();
        userData.add(userLogin);

        System.out.print("Password: ");
        userPassword = input.input();
        userData.add(userPassword);

        return userData;
    }
}

