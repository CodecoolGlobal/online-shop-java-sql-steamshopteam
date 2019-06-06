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

public class MainTest {

    public static void main(String[] args) {
        User user = new User(0, "", "", 0);

        CategoryDao categoryDao = new CategoryDao();
        OrderDao orderDao = new OrderDao();
        System.out.println(categoryDao.read());
        Category category = new Category("test999");
        category.setId(16);
        categoryDao.update(category);
        System.out.println(categoryDao.read());

    }

}
