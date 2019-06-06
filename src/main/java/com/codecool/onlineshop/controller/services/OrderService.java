package com.codecool.onlineshop.controller.services;

import com.codecool.onlineshop.dao.OrderDao;
import com.codecool.onlineshop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    OrderDao orderDao;

    public OrderService() {
         orderDao = new OrderDao();
    }

    public List readAll() {
        return orderDao.read();
    }

    public Order readOf(int index){

        List<Order> orderList = new ArrayList<>();
        Order ord = new Order();
        orderList = orderDao.read();

        for(Order order : orderList) {
            if(order.getId_order() == index) {
                ord = order;

            }
        }
        return ord;
    }

    public List readAllByUser(int UserId) {
        List<Order> orderList = new ArrayList<>();
        List<Order> filteredOrderList = new ArrayList<>();

        Order ord = new Order();
        orderList = orderDao.read();

        for (Order order : orderList) {
            if (order.getId_owner() == UserId) {
                filteredOrderList.add(order);
            }
        }
        return filteredOrderList;
    }

    public void create(String orderCreateDate, String payDate, int idOwner, int idStatus, int idProduct){
        orderDao.create(new Order(orderCreateDate,payDate,idOwner,idStatus,idProduct));
    }

}
