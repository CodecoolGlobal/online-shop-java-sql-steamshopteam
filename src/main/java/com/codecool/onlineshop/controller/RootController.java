package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.ProductService;

public class RootController {

    CategoryController categoryController = new CategoryController();
    ProductController productController = new ProductController();

     public void run(){
         //categoryController.createNewCategory();
         //categoryController.editNameExistCategory();
         //productController.deactiveEmptyProduct();
<<<<<<< HEAD
         //productController.updateProduct();
         productController.deactivateProduct();


=======
         productController.updateProduct();
>>>>>>> 3e91eb916f07dcfe85df48b6786d7f7d2b3dc0fa
     }
}
