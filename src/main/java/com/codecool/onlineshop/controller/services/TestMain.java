package com.codecool.onlineshop.controller.services;

public class TestMain {
    public static void main (String[] args){

        CategoryService categoryService = new CategoryService();

        System.out.println(categoryService.readAllCategory());

        categoryService.update(16,"testUpdate");
        System.out.println(categoryService.readAllCategory());


    }
}
