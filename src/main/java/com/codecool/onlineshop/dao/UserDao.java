package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.dao.interfaces.Dao;
import com.codecool.onlineshop.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {
    private SqlImplementation sqlImplementation;

    public UserDao() {
        sqlImplementation = new SqlImplementation();
    }


    @Override
    public void create(User newUser) {

        //todo register new user
        try {
            //newUser = new User(3,"dupa", "yo", 1);
            sqlImplementation.doQuery("INSERT INTO Users(password, name, id_permission) VALUES ('" + newUser.getPassword() + "','" + newUser.getUserName() + "', '" + newUser.getPermission() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlImplementation.closeQuery();
        }


    }

    @Override
    public List read() {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = sqlImplementation.selectQuery("SELECT * FROM users");
        try {
            while (resultSet.next()) {

                int userId = resultSet.getInt("id");
                String password = resultSet.getString("password");
                String userName = resultSet.getString("name");
                int permission = resultSet.getInt("id_permission");
                int isLogged = resultSet.getInt("is_logged");
                User user = new User(userId, userName, password, permission, isLogged);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sqlImplementation.closeQuery();
        }
        return users;
    }


    @Override
    public void update(User user) {

        //toDo: Implement

        try {
            sqlImplementation.doQuery("UPDATE users SET password = '" + user.getPassword() + "'," +
                    "name = '" + user.getUserName() + "', id_permission = '" + user.getPermission() + "'," +
                    "is_logged = '" + user.isLogged() + "' WHERE id = '" + user.getUserId() + "'");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        } finally {
            sqlImplementation.closeQuery();
        }


    }

    @Override
    public void delete(int userId) {
        try {
            sqlImplementation.doQuery("DELETE FROM users WHERE id = '" + userId + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
