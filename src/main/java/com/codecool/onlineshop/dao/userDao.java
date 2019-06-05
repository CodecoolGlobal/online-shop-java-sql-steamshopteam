package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.model.User;
import com.codecool.onlineshop.dao.interfaces.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDao implements Dao {
   private SqlImplementation daoImplementation;

    public userDao() {
        daoImplementation = new SqlImplementation();
    }


    @Override
    public void create(Object obj) {

    }

    @Override
    public List read() {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = daoImplementation.selectQuery("SELECT * FROM users");
        try {
            while (resultSet.next()) {

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
    public void update() {

    }

    @Override
    public void delete() {

    }
}
