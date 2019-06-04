package com.codecool.onlineshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoImplementation implements Dao {


    @Override
    public List<User> getUser() throws SQLException {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = inputQuery("SELECT * FROM users");
        try{
            while(resultSet.next()){

                int userId = resultSet.getInt("id");
                String password = resultSet.getString("password");
                String userName = resultSet.getString("name");
                int permission = resultSet.getInt("permission");
                User user = new User(userId, userName, password, permission);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }



    @Override
    public User addUser() {
        return null;
    }

    @Override
    public User rmUser() {
        return null;
    }

    @Override
    public Product getProduct() {
        return null;
    }

    @Override
    public Product addProduct() {
        return null;
    }

    @Override
    public Product rmProduct() {
        return null;
    }

    @Override
    public List<Category> getCategory() {
        return null;
    }

    @Override
    public Category addCategory() {
        return null;
    }

    @Override
    public Category rmCategory() {
        return null;
    }

    @Override
    public Order getOrder() {
        return null;
    }

    @Override
    public Order addOrder() {
        return null;
    }

    @Override
    public Order rmOrder() {
        return null;
    }

    private ResultSet inputQuery(String sql) {
        ResultSet resultSet = null;
        try {
            ConnectToSql connect = new ConnectToSql();
            Connection con = connect.connect();
            Statement statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
