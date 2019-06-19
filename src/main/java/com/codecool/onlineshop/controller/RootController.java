package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.ProductService;

public class RootController {

    CategoryController categoryController = new CategoryController();
    ProductController productController = new ProductController();

     public void run(){
         //categoryController.createNewCategory();
         //categoryController.editNameExistCategory();
         //productController.deactiveEmptyProduct();
         //productController.updateProduct();
         productController.deactivateProduct();
         productController.updateProduct();

     }
}
