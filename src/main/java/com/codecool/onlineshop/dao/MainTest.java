package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.codecool.onlineshop.model.Category;
import com.codecool.onlineshop.model.Order;
import com.codecool.onlineshop.view.UI;

public class MainTest {
    private User user = new User(0, "", "", 0);
    private boolean isLogged;

    public static void main(String[] args)
    {
        MainTest main = new MainTest();
        CategoryDao categoryDao = new CategoryDao();
        OrderDao orderDao = new OrderDao();
        System.out.println(categoryDao.read());
        Category category = new Category("testo");
        //categoryDao.create(category);
        System.out.println(categoryDao.read());
        categoryDao.update();
        Order order = new Order("12.12.2019","null",1,1,1);
        orderDao.create(order);
        System.out.println(orderDao.read());

        UI ui = new UI();
        ui.start();

        main.checkLogin();
    }

    private Map<String, String> sendQuerry(String querry)
    {
        Map<String, String> userData = new HashMap<>();
        String login;
        String password;

        try {
            ConnectToSql connect = new ConnectToSql();
            Connection con = connect.connect();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(querry);

            while (resultSet.next() && !isLogged)
            {
                login = resultSet.getString("name");
                password = resultSet.getString("password");
                userData.put(login, password);
            }
            connect.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }

    private void checkLogin()
    {
        MainTest main = new MainTest();
        String login = "";
        String password = "";

        List<String> userData = user.login();
        String userLogin = userData.get(0);
        String userPassword = userData.get(1);

        for ( Map.Entry<String, String> entry : main.sendQuerry("SELECT name, password from Users").entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            login = key;
            password = value;

            if(userLogin.equals(login) && userPassword.equals(password))
            {
                System.out.println("Logged successfully!");
                isLogged = true;
                break;
            }
        }
        if(!userLogin.equals(login) && !userPassword.equals(password)) {
            System.out.println("Wrong login or password!");
    }
        //------- debug -------- log and pass from sql; user input log and pass
        System.out.println("\nlogin: " + login + ", pass: " + password);
        System.out.println("userInput: " + userLogin + ", pass: " + userPassword + "\n");
    }
}
