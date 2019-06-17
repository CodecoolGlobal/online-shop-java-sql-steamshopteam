package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.model.Basket;
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
        BasketDao basketDao = new BasketDao();
//        basketDao.create(new Basket(1, 4));
//        basketDao.create(new Basket(1, 2));
//        basketDao.create(new Basket(1, 3));
//        basketDao.create(new Basket(1, 5));
        List<Basket> baskets = basketDao.read();
        for (Basket basket : baskets) {
            if (basket.getAmount() == 0){
                basketDao.update(new Basket(basket.getOwnerId(), basket.getProduct(), 5));
            }

        }
        System.out.println(basketDao.read());



    }

}
