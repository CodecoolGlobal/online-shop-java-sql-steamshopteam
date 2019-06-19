package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.BasketService;
import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.model.User;
import com.codecool.onlineshop.model.UserLogin;
import com.codecool.onlineshop.view.Print;

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
    public void addProductToBasket(){
        String productName;
        int amout;
        Print.printText("Enter name of item what do you want to add: ");
        productName = ReadInput.UserStringInput();
        Print.printText("Enter amount of item what do you want to add: ");
        amout = ReadInput.UserIntInput();
        if(!productName.equals("") && amout > 0){
            basketService.addProductToBasket(user,productService.getProductByName(productName),amout);
        }
    }

    public void showUserBasket(User user){
        basketService.getUserBasket(user);
    }

    public void editBasket(User user){
        List<Product> productList = productService.getAllProducts();
        Print.printText("Enter name of item what dou you want edit: ");
        String productName = ReadInput.UserStringInput();
        Print.printText("Enter new amount of product: ");
        int amount = ReadInput.UserIntInput();
        for(Product product : productList){

            if(product.getName().equals(productName)){
                basketService.editBasket(user,product, productName,amount);
            }
        }

    }
}
