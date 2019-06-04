package com.codecool.onlineshop.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao {

    List<User> getUser() throws SQLException;
    User addUser();
    User rmUser();
    Product getProduct();
    Product addProduct();
    Product rmProduct();
    Category getCategory();
    Category addCategory();
    Category rmCategory();
    Order getOrder();
    Order addOrder();
    Order rmOrder();

}
