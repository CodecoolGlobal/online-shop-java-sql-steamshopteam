package com.codecool.onlineshop.model;

import com.codecool.onlineshop.controller.CategoryController;
import com.codecool.onlineshop.controller.services.CategoryService;
import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.controller.services.UserService;
import com.codecool.onlineshop.view.Viewer;

import java.util.ArrayList;
import java.util.List;

public class ConvertToArrays {

    private Viewer viewer = new Viewer();

    public void sendProductsToTable(List<Product> incomingData) {
        List<Category> categoryList = new ArrayList<>();
        categoryList = new CategoryService().readAllCategory();
        List<List<String>> productsList = new ArrayList<>();

        int counter = 0;

        for (Product product : incomingData) {
            productsList.add(new ArrayList<>());

            productsList.get(counter).add(String.valueOf(counter + 1));
            productsList.get(counter).add(product.getName());
            productsList.get(counter).add(String.valueOf(product.getPrice()));
            productsList.get(counter).add(String.valueOf(product.getAmount()));
            productsList.get(counter).add(product.getIsAvailable() == 1 ? "available" : "unavailable");
            for(Category category : categoryList)
                if(product.getCategoryId() == category.getId()) {
                    productsList.get(counter).add(String.valueOf(category.getName()));
                    break;
                }

            counter += 1;
        }

        viewer.displayTable(productsList);
    }

    public void sendBasketToTable(List<Basket> incomingData) {
        List<List<String>> productsList = new ArrayList<>();
        UserService userService = new UserService();
        ProductService productService = new ProductService();

        int counter = 0;

        for (Basket basket : incomingData) {
            productsList.add(new ArrayList<>());

            productsList.get(counter).add(String.valueOf(userService.getPlayerById(basket.getOwnerId()).getUserName()));
            productsList.get(counter).add(String.valueOf(basket.getAmount()));
            productsList.get(counter).add(String.valueOf(productService.getProductById(basket.getProduct()).getName()));

            counter += 1;
        }

        viewer.displayTable(productsList);
    }

}
