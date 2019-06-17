package com.codecool.onlineshop.model;

import com.codecool.onlineshop.controller.services.UserService;
import com.codecool.onlineshop.dao.MainTest;
import com.codecool.onlineshop.view.UI;

import java.util.List;

public class UserLogin {

    private UserService userService = new UserService();
    private UserInput input = new UserInput();

    private boolean isLogged = false;

    public void login() {
        String userLogin;
        String userPassword;
        List<User> allUsers = userService.readAllUsers();

        System.out.print("Login: ");
        userLogin = input.input();

        if(!isLogged)
        {
            for (User user : allUsers) {

                if (userLogin.equals(user.getUserName())) {
                    System.out.print("Password: ");
                    userPassword = input.input();

                    if (user.getPassword().equals(userPassword)) {
                        System.out.println("Login successfull\n");
                        MainTest.start(true);
                    } else {
                        System.out.println("Wrong password!\n");
                    }
                } else {
                    System.out.println("\n");
                }
            }
        } else {
            System.out.println("Already logged!");
        }
    }

}
