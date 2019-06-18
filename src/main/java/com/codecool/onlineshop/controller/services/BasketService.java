package com.codecool.onlineshop.controller.services;

import com.codecool.onlineshop.dao.BasketDao;
import com.codecool.onlineshop.model.Basket;
import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.model.User;


import java.util.List;

public class BasketService {
    BasketDao basketDao;
    ProductService productService;

    public BasketService() {
        basketDao = new BasketDao();
        productService = new ProductService();
    }

    public void addProductToBasket(User user, Product product, int amount) {

        if (productService.getProductByName(product.getName()).getAmount() >= amount) {
            productService.updateProductAmount(product.getName(), product.getAmount() - amount);
            basketDao.create(new Basket(user.getUserId(), product.getId(), amount));
        } else {
            System.out.println("Sorry but we haven`t got enough amount of this product!");
        }
    }

    public Basket getUserBasket(User user) {
        List<Basket> basketList = basketDao.read();
        for (Basket basket : basketList) {
            if (basket.getOwnerId() == user.getUserId()) {
                return basket;
            }
        }
        return null;
    }

    public void editBasket(User user, Product product, String productName, int amount) {
        Basket basket = getUserBasket(user);

        if (basket.getOwnerId() == user.getUserId()) {
            if (product.getName().equals(productName)) {
                if(amount > basket.getAmount()){
                    if ((amount - basket.getAmount()) <= productService.getProductByName(productName).getAmount()) {
                        productService.updateProductAmount(productName, product.getAmount() - (amount - basket.getAmount()));
                        basketDao.update(new Basket(user.getUserId(), basket.getProduct(), amount));
                    } else {
                        System.out.println("Too much");
                    }
                } else {
                    if(productService.getProductByName(productName).getAmount() >= amount) {
                        productService.updateProductAmount(productName, basket.getAmount() + product.getAmount());
                        basketDao.update(new Basket(user.getUserId(), basket.getProduct(), amount));
                    } else {
                        System.out.println("Too much");

                    }
                }
            }
        }
    }

    public void deleteProductFromBasket(User user, Product product, String productName){
        Basket basket = getUserBasket(user);
        if (basket.getOwnerId() == user.getUserId()) {
            if (product.getName().equals(productName)) {
                productService.updateProductAmount(productName, product.getAmount() + basket.getAmount());
                basketDao.delete(product.getId());
            }
        }

    }
}

