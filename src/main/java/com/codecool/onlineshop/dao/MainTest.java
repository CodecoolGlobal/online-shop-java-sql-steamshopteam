package com.codecool.onlineshop.dao;


import com.codecool.onlineshop.model.Category;

public class MainTest {
    public static void main(String[] atgs) {

        CategoryDao categoryDao = new CategoryDao();
        System.out.println(categoryDao.read());
        Category category =new Category("testo",666);
        //categoryDao.create(category);
        System.out.println(categoryDao.read());
        categoryDao.update();



    }
}
