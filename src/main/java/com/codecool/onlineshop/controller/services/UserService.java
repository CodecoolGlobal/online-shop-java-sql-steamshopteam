package com.codecool.onlineshop.controller.services;

import com.codecool.onlineshop.dao.UserDao;
import com.codecool.onlineshop.model.User;

import java.util.List;

public class UserService {
    private UserDao userDao;

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
    public void updateUser(int userName){
        List<User> userList = userDao.read();
        for(User user : userList){
            if(user.getUserName().equals(userName)){
                userDao.update(user);
            }
        }



    }




}
