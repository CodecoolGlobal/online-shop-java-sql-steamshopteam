package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.model.User;
import com.codecool.onlineshop.model.UserLogin;

public class RootController {
    private User user = new User();
    private UserLogin userLogin = new UserLogin();


    CategoryController categoryController = new CategoryController();
    ProductController productController = new ProductController();


     public void run(){
         user = userLogin.getLoggedUser();
         BasketController basketController = new BasketController(user);
         basketController.addProductToBasket();
         //categoryController.createNewCategory();
         //categoryController.editNameExistCategory();
         //productController.deactiveEmptyProduct();
     }
}
