package com.codecool.onlineshop.dao;

import java.util.List;

public interface Dao {

    User getUser();
    User addUser();
    User rmUser();
    Product getProduct();
    Product addProduct();
    Product rmProduct();
    List<Category> getCategory();
    Category addCategory();
    Category rmCategory();
    Order getOrder();
    Order addOrder();
    Order rmOrder();

}
