package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.BasketService;
import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.*;
import com.codecool.onlineshop.view.Print;

import java.util.ArrayList;
import java.util.List;

public class BasketController {
    private BasketService basketService;
    private User user;
    private ProductService productService;

    public BasketController(User user) {
        this.user = user;
        basketService = new BasketService();
        //userLogin = new UserLogin();
        productService = new ProductService();
    }

    public void addProductToBasket() {
        String productName;
        int amout;
        Print.printText("Enter name of item what do you want to add: ");
        productName = ReadInput.UserStringInput();
        Print.printText("Enter amount of item what do you want to add: ");
        amout = ReadInput.UserIntInput();
        if (!productName.equals("") && amout > 0) {
            Product product = productService.getProductByName(productName);
            basketService.addProductToBasket(user, product, amout);
        }
    }

    public void showUserBasket(User user) {
        List<Basket> basketList = basketService.getUserBasket(user);
        List<String> headers = new ArrayList<>();
        headers.add("Owner");
        headers.add("amount");
        headers.add("Prod id");
        new ConvertToArrays().sendBasketToTable(basketList, headers);
    }


    public void editBasket(User user) {
        List<Product> productList = productService.getAllProducts();
        Print.printText("Enter name of item what dou you want edit: ");
        String productName = ReadInput.UserStringInput();
        Print.printText("Enter new amount of product: ");
        int amount = ReadInput.UserIntInput();
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                basketService.editBasket(user, product, productName, amount);
            }
        }
    }

    public void deleteProductFromBasket() {
        Print.printText("Enter name of product to delete from basket: ");
        String productName = ReadInput.UserStringInput();
        if (productService.getProductByName(productName).getName().equals(productName)) {
            basketService.deleteProductFromBasket(user, productService.getProductByName(productName));
        }

    }

    public void makeOrder(){
        new OrderController(user).makeOrder();
    }

    public void payForOrder(){
        new OrderController(user).payForOrder();
    }
}
