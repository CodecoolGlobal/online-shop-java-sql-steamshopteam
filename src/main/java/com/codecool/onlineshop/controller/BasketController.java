package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.BasketService;
import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.Basket;
import com.codecool.onlineshop.model.ConvertToArrays;
import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.model.User;
import com.codecool.onlineshop.view.Print;

import java.util.ArrayList;
import java.util.List;

public class BasketController {
    private BasketService basketService;
    private User user;
    private ProductService productService;
    private ProductController productController;

    public BasketController(User user) {
        this.user = user;
        this.basketService = new BasketService();
        this.productService = new ProductService();
        this.productController = new ProductController();
    }

    public void addProductToBasket() {
        String productName;
        int amout;
        productController.showAllProducts();
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
        new ConvertToArrays().sendBasketToTable(basketList);
    }


    public void editBasket(User user) {
        showUserBasket(user);
        List<Product> productList = productService.getAllProducts();
        Print.printText("Enter name of item what dou you want edit: ");
        String productName = ReadInput.UserStringInput();
        Print.printText("Enter new amount of product: ");
        int amount = ReadInput.UserIntInput();
        if(amount > 0) {
            for (Product product : productList) {
                if (product.getName().equals(productName)) {
                    basketService.editBasket(user, product, productName, amount);
                }
            }
        }
    }

    public void deleteProductFromBasket() {
        showUserBasket(user);
        Print.printText("Enter name of product to delete from basket: ");
        String productName = ReadInput.UserStringInput();
        if (productService.getProductByName(productName).getName().equals(productName)) {
            basketService.deleteProductFromBasket(user, productService.getProductByName(productName));
        }

    }

    public void deleteProductsFromBasket(User user){
        List<Basket> basketList = basketService.getUserBasket(user);
        for(Basket basket : basketList){
            if(basket.getOwnerId() == user.getUserId()) {
                basketService.deleteProductsFromBasket(basket);
            }
        }

    }

}
