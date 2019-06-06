package com.codecool.onlineshop.view;

import com.codecool.onlineshop.dao.SqlImplementation;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UI {

    private boolean isLogged;
    private int permission;

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
        System.out.println("1. Login\n2. Exit");
    }

    private void showShopMenu()
    {
        System.out.println("1. ");
    }

    private void showAdminPanel()
    {

    }
}
