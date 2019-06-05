package com.codecool.onlineshop.dao;


public class MainTest {
    public static void main(String[] atgs) {

        CategorySql categoryDao = new CategorySql();
        System.out.println(categoryDao.read());
        categoryDao.create("test", "1");
        System.out.println(categoryDao.read());



    }
}
