package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.controller.services.BasketService;
import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.controller.services.UserService;
import com.codecool.onlineshop.model.*;
import com.codecool.onlineshop.model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {

    public static void main(String[] args) {
        BasketService basketService = new BasketService();
        UserService userService = new UserService();
        User user = userService.readOf("root");
        ProductService productService = new ProductService();
        Product product = productService.getProductByName("myszka");

        basketService.addProductToBasket(user, product, 5);

    }


}


