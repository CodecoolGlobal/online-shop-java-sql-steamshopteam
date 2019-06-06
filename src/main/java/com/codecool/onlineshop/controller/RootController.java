package com.codecool.onlineshop.controller;

public class rootController {

    CategoryController categoryController = new CategoryController();

     public void run(){
         categoryController.createNewCategory();
     }
}
