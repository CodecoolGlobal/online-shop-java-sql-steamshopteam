package com.codecool.onlineshop.controller.services;

import com.codecool.onlineshop.dao.ConnectToSql;
import com.codecool.onlineshop.dao.UserDao;
import com.codecool.onlineshop.model.User;
import com.codecool.onlineshop.model.UserInput;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private UserDao userDao;

    private UserInput input = new UserInput();

    public UserService() {
        userDao = new UserDao();
    }


    public void create(String userName, String password, int permission) {
        userDao.create(new User(userName, password, permission));
    }

    public List readAllUsers() {
        return userDao.read();
    }

    public User readOf(String userName){
        List<User> userList = userDao.read();
        for (User user : userList) {
            if(user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }
    public void updateUser(String userName){
        List<User> userList = userDao.read();
        for(User user : userList){
            if(user.getUserName().equals(userName)){
                userDao.update(user);
            }
        }
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

    private Map<String, String> sendQuerry(String querry)
    {
        Map<String, String> userData = new HashMap<>();
        String login;
        String password;
        boolean isLogged = false;

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

    public void checkLogin()
    {
        String login = "";
        String password = "";

        List<String> userData = login();
        String userLogin = userData.get(0);
        String userPassword = userData.get(1);

        for ( Map.Entry<String, String> entry : sendQuerry("SELECT name, password, " +
                "is_logged from Users").entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            login = key;
            password = value;

            if(userLogin.equals(login) && userPassword.equals(password))
            {
                System.out.println("Logged successfully!");
                //updateUser(login);
                break;
            }
        }
        if(!userLogin.equals(login) && !userPassword.equals(password)) {
            System.out.println("Wrong login or password!");
        }
        //------- debug -------- log and pass from sql; user input log and pass
        //System.out.println("\nlogin: " + login + ", pass: " + password);
        //System.out.println("userInput: " + userLogin + ", pass: " + userPassword + "\n");
    }


}
