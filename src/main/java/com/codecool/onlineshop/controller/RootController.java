package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.User;
import com.codecool.onlineshop.model.UserLogin;
import com.codecool.onlineshop.view.Ui;

public class RootController {
    private User user = new User();
    private Ui ui;
    private UserLogin userLogin;
    private ProductService productService;


    CategoryController categoryController = new CategoryController();
    ProductController productController = new ProductController();


    public void run() {
        this.userLogin = new UserLogin();
        this.productService = new ProductService();
        this.ui = new Ui(userLogin, productService);
        ui.start();

        //user = userLogin.getLoggedUser();
        BasketController basketController = new BasketController(user);
        basketController.addProductToBasket();
        //categoryController.createNewCategory();
        //categoryController.editNameExistCategory();
        //productController.deactiveEmptyProduct();
    }

}
