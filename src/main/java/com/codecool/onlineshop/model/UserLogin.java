package com.codecool.onlineshop.model;

import com.codecool.onlineshop.dao.ConnectToSql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserLogin {

    private User user = new User(0, "", "", 0);
    private boolean isLogged;

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
                isLogged = resultSet.getInt("is_logged") != 0;
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
        UserLogin usLog = new UserLogin();
        String login = "";
        String password = "";

        List<String> userData = user.login();
        String userLogin = userData.get(0);
        String userPassword = userData.get(1);

        for ( Map.Entry<String, String> entry : usLog.sendQuerry("SELECT name, password, " +
                "id_permission from Users").entrySet()) {
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
