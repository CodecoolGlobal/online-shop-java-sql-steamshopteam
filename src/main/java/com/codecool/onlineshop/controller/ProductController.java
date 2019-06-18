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
}
