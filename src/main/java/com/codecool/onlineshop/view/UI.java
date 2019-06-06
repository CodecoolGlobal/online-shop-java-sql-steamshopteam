package com.codecool.onlineshop.view;

import com.codecool.onlineshop.dao.SqlImplementation;
import com.codecool.onlineshop.model.User;
import com.codecool.onlineshop.model.UserInput;
import com.codecool.onlineshop.model.UserLogin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UI {

    private boolean isLogged;
    private int permission;

    private UserInput input = new UserInput();
    private UserLogin userLogin = new UserLogin();

    public void start()
    {
        SqlImplementation sqlImplementation = new SqlImplementation();
        String sqlQuerry = "SELECT id_permission, is_logged FROM users ";
        ResultSet resultSet = sqlImplementation.selectQuery(sqlQuerry);

        try {
            isLogged = resultSet.getInt("is_logged") != 0;
            permission = resultSet.getInt("id_permission");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        showMenu();
    }

    private void showMenu()
    {
        int userPerm = 0;
        int adminPerm = 1;

        if(isLogged && permission == userPerm)
            showShopMenu();
        else if(isLogged && permission == adminPerm)
            showAdminPanel();
        else
            showLoginMenu();
    }

    private void showLoginMenu()
    {
        int choice = 0;

        System.out.println("1. Login\n2. Exit");
        choice = Integer.parseInt(input.input());

        switch (choice)
        {
            case 1:
                userLogin.checkLogin();
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
