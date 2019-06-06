package com.codecool.onlineshop.controller;

public class RootController {

    CategoryController categoryController = new CategoryController();

     public void run(){
         //categoryController.createNewCategory();
         categoryController.editNameExistCategory();
     }
}
