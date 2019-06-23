package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.UserLogin;

public class RootController {
    private UiController uiController;
    private UserLogin userLogin;
    private ProductService productService;

    public void run() {
        this.userLogin = new UserLogin();
        this.productService = new ProductService();
        this.uiController = new UiController(userLogin);
        this.uiController.start();


    }

}
