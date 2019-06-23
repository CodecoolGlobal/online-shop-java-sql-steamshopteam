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
    public User getPlayerById(int id){
        List<User> userList = userDao.read();
        for (User user : userList) {
            if(user.getUserId() == id){
                return user;
            }
        }
        return null;
    }

    public void updateUserName(String userName, String newUserName){
        User user = readOf(userName);
        user.setUserName(newUserName);
        userDao.update(user);
    }
    public void updateUserPassword(String userName, String newPassword){
        User user = readOf(userName);
        user.setPassword(newPassword);
        userDao.update(user);
    }
    public void updateUserIdPermission(String userName, int newPermissionId){
        User user = readOf(userName);
        user.setPermission(newPermissionId);
        userDao.update(user);
    }
    public void updateUserLogin(String userName, int isLogged){
        User user = readOf(userName);
        user.setIsLogged(isLogged);
        userDao.update(user);
    }
}
