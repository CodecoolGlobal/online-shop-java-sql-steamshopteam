package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.view.Print;

public class ProductController {

    private ProductService productService;

    public ProductController() {
        productService = new ProductService();
    }

    public void deactiveEmptyProduct() {
        productService.deactiveProductWhenQuantityEquals0();
        Print.printText("Deactivate empty product");
    }

    public void createNewProduct() {
        Print.printText("Product name: ");
        String name = ReadInput.UserStringInput();
        Print.printText("Product amount");
        int amount = ReadInput.UserIntInput();
        Print.printText("Product isAvailable");
        int isAvailable = ReadInput.UserIntInput();
        Print.printText("Product categoryId");
        int categoryId = ReadInput.UserIntInput();
        Print.printText("Product price");
        float price = ReadInput.UserFloatInput();

        new ProductService().create(name, amount, isAvailable, categoryId, price);

    }
}
