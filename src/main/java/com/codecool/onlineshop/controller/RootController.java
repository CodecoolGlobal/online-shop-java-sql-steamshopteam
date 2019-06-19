package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.User;
import com.codecool.onlineshop.model.UserLogin;

public class RootController {
    private User user = new User();
    private UiController uiController;
    private UserLogin userLogin;
    private ProductService productService;
    private BasketController basketController;


    CategoryController categoryController = new CategoryController();
    ProductController productController = new ProductController();


    public void run() {
        this.userLogin = new UserLogin();
        this.productService = new ProductService();
        this.uiController = new UiController(userLogin);
        uiController.start();

        //user = userLogin.getLoggedUser();
        //BasketController basketController = new BasketController(user);
        //basketController.addProductToBasket();
        //categoryController.createNewCategory();
        //categoryController.editNameExistCategory();
        //productController.deactiveEmptyProduct();
    }

}
