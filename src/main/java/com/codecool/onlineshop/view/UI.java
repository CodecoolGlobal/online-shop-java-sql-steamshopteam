package com.codecool.onlineshop.view;

import com.codecool.onlineshop.model.UserInput;
import com.codecool.onlineshop.model.UserLogin;

public class UI {

    private UserInput input = new UserInput();
    private UserLogin userLogin = new UserLogin();

    public void start(boolean isLogged) {
        showMenu(isLogged);
    }

    private void showMenu(boolean isLogged)
    {

        if(isLogged)
            showShopMenu();
        else
            showLoginMenu();
    }

    private void showLoginMenu()
    {
        System.out.println("1. Login\n2. Exit");
        int choice = Integer.parseInt(input.input());

        switch (choice)
        {
            case 1:
                userLogin.login();
            case 2:
                System.exit(0);
        }
    }

    private void showShopMenu()
    {
        System.out.println("1. Add product to basket\n" +
                "2. Show basket\n" +
                "3. Edit basket\n" +
                "4. Delete from basket\n" +
                "5. Place order\n" +
                "6. Show order history\n" +
                "7. Show available products\n" +
                "8. Show product in category\n" +
                "9. Show products availability\n" +
                "10. Rate product\n" +
                "11. Order history statistics");
    }

    private void showAdminPanel()
    {
        System.out.println("1. Add new category\n" +
                "2. Edit category\n" +
                "3. Automatic deactive product\n" +
                "4. Create new product\n" +
                "5. Edit product properties\n" +
                "6. Deactive product\n" +
                "7. Create discount\n" +
                "8. Show orders list\n" +
                "9. Show orders feedbacks\n");
    }
}
