package com.codecool.onlineshop.dao;


import com.codecool.onlineshop.model.Category;
import com.codecool.onlineshop.model.User;

public class MainTest {
    public static void main(String[] atgs) {

        CategorySql categoryDao = new CategorySql();
        System.out.println(categoryDao.read());
        Category category =new Category("testo",666);
        categoryDao.create(category);
        System.out.println(categoryDao.read());



    }
}
