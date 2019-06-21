package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.model.UserLogin;

import java.io.IOException;

public class UiController {

    private UserLogin userLogin;
    private boolean isLogged = false;
    private Options option;

    UiController(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public void start() {
        if (this.isLogged) {
            this.option = new Options(userLogin.getLoggedUser());
            showMenu();
        } else {
            showLoginMenu();
        }
    }

    private void showMenu() {
        int permission = userLogin.getLoggedUser().getPermission();
        while(isLogged) {
            String filePath;
            filePath = (permission == 1) ? "src/resources/adminOptions.txt" : "src/resources/customerOptions.txt";
            menuIterator(filePath);

            String userChoice;

            System.out.println("\nYour choice: ");

            userChoice = ReadInput.UserStringInput();

            option.run(filePath, userChoice);
        }
    }

    private void showLoginMenu() {
        System.out.println("1. Login\n2. Exit");
        int choice = ReadInput.UserIntInput();

        switch (choice) {
            case 1:
                userLogin.login(this);
            case 2:
                System.exit(0);
        }
    }

    private void menuIterator(String filePath)
    {
        try {
            for(String option : option.loadOptions(filePath))
            {
                System.out.println(option);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
