package com.codecool.onlineshop.model;

import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.controller.services.UserService;
import com.codecool.onlineshop.view.Viewer;

import java.util.ArrayList;
import java.util.List;

public class ConvertToArrays {

    private Viewer viewer = new Viewer();
    private UserService userService = new UserService();
    private ProductService productService = new ProductService();

    public void sendProductsToTable(List<Product> incomingData) {
        List<List<String>> productsList = new ArrayList<>();
        List<String> headers = new ArrayList<>();
        headers.add("ID");
        headers.add("NAME");
        headers.add("PRICE");
        headers.add("AMOUNT");
        headers.add("isAVAILABLE");
        headers.add("CATEGORY");

        int counter = 0;

        for (Product product : incomingData) {
            productsList.add(new ArrayList<>());

            productsList.get(counter).add(String.valueOf(counter + 1));
            productsList.get(counter).add(product.getName());
            productsList.get(counter).add(String.valueOf(product.getPrice()));
            productsList.get(counter).add(String.valueOf(product.getAmount()));
            productsList.get(counter).add(String.valueOf(product.getIsAvailable()));
            productsList.get(counter).add(String.valueOf(product.getCategoryId()));

            counter += 1;
        }

        viewer.displayTable(productsList, headers);
    }

    public void sendBasketToTable(List<Basket> incomingData, List<String> header) {
        List<List<String>> productsList = new ArrayList<>();

        int counter = 0;

        for (Basket basket : incomingData) {
            productsList.add(new ArrayList<>());

            productsList.get(counter).add(String.valueOf(userService.getPlayerById(basket.getOwnerId()).getUserName()));
            productsList.get(counter).add(String.valueOf(basket.getAmount()));
            productsList.get(counter).add(String.valueOf(productService.getProductById(basket.getProduct()).getName()));

            counter += 1;
        }

        viewer.displayTable(productsList, header);
    }

    public void sendOrdersToTable(List<Order> incomingData, List<String> header){
        List<List<String>> orderList = new ArrayList<>();

        int counter = 0;

        for (Order order : incomingData) {
            orderList.add(new ArrayList<>());

            orderList.get(counter).add(String.valueOf(order.getOrderDate()));
            orderList.get(counter).add(String.valueOf(order.getPayDate()));
            orderList.get(counter).add(String.valueOf(order.getId_status()));
            orderList.get(counter).add(String.valueOf(productService.getProductById(order.getId_product()).getName()));
            orderList.get(counter).add(String.valueOf(order.getAmount()));
            counter += 1;
        }

        viewer.displayTable(orderList, header);
    }

}
