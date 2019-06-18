package com.codecool.onlineshop.controller;

public class RootController {

    CategoryController categoryController = new CategoryController();
    ProductController productController = new ProductController();

     public void run(){
         //categoryController.createNewCategory();
         //categoryController.editNameExistCategory();
         productController.deactiveEmptyProduct();
         productController.updateProduct();
     }
}
