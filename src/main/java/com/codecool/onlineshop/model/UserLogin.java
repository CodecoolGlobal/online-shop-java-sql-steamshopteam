package com.codecool.onlineshop.model;

import com.codecool.onlineshop.controller.ReadInput;
import com.codecool.onlineshop.controller.UiController;
import com.codecool.onlineshop.controller.services.UserService;

import java.util.List;

public class UserLogin {

    private UserService userService = new UserService();

    private User loggedUser;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void login(UiController uiController) {
        String userLogin;
        String userPassword;
        List<User> allUsers = userService.readAllUsers();

        System.out.print("Login: ");
        userLogin = ReadInput.UserStringInput();

        boolean isLogged = false;
        int adminPerm = 1;

        if (!isLogged) {
            for (User user : allUsers) {
                if (userLogin.equals(user.getUserName())) {
                    System.out.print("Password: ");
                    userPassword = ReadInput.UserStringInput();
                    if (user.getPassword().equals(userPassword)) {
                        loggedUser = user;
                        System.out.println("Login successfull\nPermission: "
                                + (getLoggedUser().getPermission() == adminPerm ? "Admin\n" : "User\n"));
                        uiController.setLogged(true);
                        uiController.start();
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
