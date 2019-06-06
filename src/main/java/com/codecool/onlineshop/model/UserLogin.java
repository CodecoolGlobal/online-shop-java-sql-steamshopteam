package com.codecool.onlineshop.model;

import com.codecool.onlineshop.controller.services.UserService;

import java.util.List;

public class UserLogin {

    private UserService userService = new UserService();
    private UserInput input = new UserInput();

    public void login() {
        String userLogin;
        String userPassword;
        List<User> allUsers = userService.readAllUsers();

        for (User user : allUsers) {
            System.out.println(user.getUserName());
        }

        System.out.print("Login: ");
        userLogin = input.input();

        for (User user : allUsers) {

            if (userLogin.equals(user.getUserName())) {
                System.out.print("Password: ");
                userPassword = input.input();

                if (user.getPassword().equals(userPassword)) {
                    System.out.println("Login successfull");

                    userService.updateUserLogin(userLogin, 1);
                } else {
                    System.out.println("Wrong password!");
                }
            }
        }
    }

}
