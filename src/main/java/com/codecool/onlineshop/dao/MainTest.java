package com.codecool.onlineshop.dao;


import com.codecool.onlineshop.model.Category;
import com.codecool.onlineshop.model.Product;

public class MainTest {
    public static void main(String[] atgs) {

        ProductDao productDao = new ProductDao();
        Product product = new Product(1,"dupa",199,9,1,1);
        productDao.create(product);
        System.out.println(productDao.read());


    }
}
