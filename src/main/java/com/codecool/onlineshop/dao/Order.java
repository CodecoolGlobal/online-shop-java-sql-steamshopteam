package com.codecool.onlineshop.dao;

import java.util.Date;

public class Order {
    private int id;
    private Basket basket;
    private User user;
    private Date orderCreatedAt;
    private Date orderPayAt;
    //private OrderStatus orderStatus;

    public boolean pay()
    {
        return true;
    }
}
