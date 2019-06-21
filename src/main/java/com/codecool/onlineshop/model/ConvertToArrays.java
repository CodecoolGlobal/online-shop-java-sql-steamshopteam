package com.codecool.onlineshop.model;


import com.codecool.onlineshop.controller.services.CategoryService;
import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.controller.services.UserService;
import com.codecool.onlineshop.view.Viewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertToArrays {

    private Viewer viewer = new Viewer();
    private UserService userService = new UserService();
    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();

    public void sendProductsToTable(List<Product> incomingData) {
        List<List<String>> productsList = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
        categoryList = categoryService.readAllCategory();
        List<String> headers;

        headers = Arrays.asList("ID", "NAME", "PRICE", "AMOUNT", "isAVAILABLE", "CATEGORY");

        int counter = 0;

        for (Product product : incomingData) {
            productsList.add(new ArrayList<>());

            productsList.get(counter).add(String.valueOf(counter + 1));
            productsList.get(counter).add(product.getName());
            productsList.get(counter).add(String.valueOf(product.getPrice()));
            productsList.get(counter).add(String.valueOf(product.getAmount()));
            productsList.get(counter).add(product.getIsAvailable() == 1 ? "available" : "unavailable");
            for (Category category : categoryList)
                if (category.getId() == product.getCategoryId()) {
                    productsList.get(counter).add(String.valueOf(category.getName()));
                    break;
                }

            counter += 1;
        }

        viewer.displayTable(productsList, headers);
    }

    public void sendBasketToTable(List<Basket> incomingData) {
        List<List<String>> productsList = new ArrayList<>();
        List<String> headers;
        headers = Arrays.asList("No.", "Item","Amount", "Price");


        int counter = 0;
        int totalPrice = 0;

        for (Basket basket : incomingData) {
            productsList.add(new ArrayList<>());

            productsList.get(counter).add(String.valueOf(counter + 1));
            productsList.get(counter).add(String.valueOf(productService.getProductById(basket.getProduct()).getName()));
            productsList.get(counter).add(String.valueOf(basket.getAmount()));
            productsList.get(counter).add(String.valueOf(productService.getProductById(basket.getProduct()).getPrice()));
            totalPrice += (productService.getProductById(basket.getProduct()).getPrice() * basket.getAmount());
            counter += 1;
        }

        viewer.displayTable(productsList, headers);

        System.out.println("Your total amount to pay is: " + totalPrice + "\n");
    }

    public void sendOrdersToTable(List<Order> incomingData) {
        List<List<String>> orderList = new ArrayList<>();
        List<String> headers;
        headers = Arrays.asList("Order Create", "Pay Date", "Order Status", "Product Name", "Product Amount");


        int counter = 0;

        for (Order order : incomingData) {
            orderList.add(new ArrayList<>());

            orderList.get(counter).add(String.valueOf(order.getOrderDate()));
            orderList.get(counter).add(String.valueOf(order.getPayDate()));
            orderList.get(counter).add(String.valueOf(categoryService.readOf(order.getId_status()).getName()));
            orderList.get(counter).add(String.valueOf(productService.getProductById(order.getId_product()).getName()));
            orderList.get(counter).add(String.valueOf(order.getAmount()));
            counter += 1;
        }

        viewer.displayTable(orderList, headers);
    }

}
