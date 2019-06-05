package com.codecool.onlineshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoImplementation implements Dao {
    ConnectToSql connect;
    Connection con;
    Statement statement;

    public DaoImplementation() {
        connect = new ConnectToSql();
    }


    @Override
    public List<User> getUser() {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = getInputQuery("SELECT * FROM users");
        try{
            while(resultSet.next()){

                int userId = resultSet.getInt("id");
                String password = resultSet.getString("password");
                String userName = resultSet.getString("name");
                int permission = resultSet.getInt("id_permission");
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
        //todo register new user
        User newUser = new User(3,"dupa", "yo", 1);
        doQuery("INSERT INTO Users(password, name, id_permission) VALUES ('"+newUser.getPassword()+"','"+newUser.getUserName()+"', '"+newUser.getPerrmission()+"')");
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
        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT * FROM category ";
        ResultSet resultSet = getInputQuery(sql);
        try {
            while (resultSet.next()) {
              Category category = new Category(resultSet.getInt("id_category"),
                      resultSet.getString("name"), resultSet.getInt("is_available"));

              categoryList.add(category);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuery();
        }
        return categoryList;
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

    public ResultSet getInputQuery(String sql) {
        ResultSet resultSet = null;
        try {
            con = connect.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public void doQuery(String sql) {
        try {
            con = connect.connect();
            statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void closeQuery(){
        try {
            this.statement.close();
            this.con.close();
            this.connect.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
