package com.codecool.onlineshop.dao;


import com.codecool.onlineshop.model.Category;
import com.codecool.onlineshop.model.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

public class MainTest {
    public static void main(String[] atgs) {

        CategoryDao categoryDao = new CategoryDao();
        OrderDao orderDao = new OrderDao();
        System.out.println(categoryDao.read());
        Category category =new Category("testo",666);
        //categoryDao.create(category);
        System.out.println(categoryDao.read());
        categoryDao.update();
        Order order = new Order("12.12.2019","null",1,1,1);
        orderDao.create(order);
        System.out.println(orderDao.read());



    }
}
