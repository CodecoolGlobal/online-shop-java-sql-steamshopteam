package com.codecool.onlineshop.controller.services;

import com.codecool.onlineshop.dao.OrderDao;
import com.codecool.onlineshop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao();
    }

    public List readAll() {
        return orderDao.read();
    }


    public List readAllByUser(int UserId) {
        List<Order> orderList = orderDao.read();
        List<Order> filteredOrderList = new ArrayList<>();


        for (Order order : orderList) {
            if (order.getId_owner() == UserId) {
                filteredOrderList.add(order);
            }
        }
        return filteredOrderList;
    }

    public void create(Order order) {
        orderDao.create(order);
    }

    public void payForOrder(Order order, String payDate) {
        order.setPayDate(payDate);
        orderDao.update(order);

    }

}
