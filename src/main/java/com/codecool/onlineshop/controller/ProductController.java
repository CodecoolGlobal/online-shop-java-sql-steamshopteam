package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.view.Print;

import java.util.List;

public class ProductController {

    private ProductService productService;

    public ProductController() {
        productService = new ProductService();
    }

    public void deactiveEmptyProduct() {
        productService.deactivateProductWhenQuantityEquals0();
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

    public void updateProduct() {
        String name;
        String productName;
        String tmpInt;
        String tmpString;
        String tmpFloat;
        int amount;
        int isAvailable;
        int categoryId;
        float price;
        Print.printText("Update product(press enter to next value");
        Print.printText("Product name to edit");
        name = ReadInput.UserStringInput();
        Print.printText("Product name");
        tmpString = ReadInput.UserStringInput();
        productName = (tmpString.equals("")) ? "" : tmpString;
        System.out.println(productName);
        Print.printText("Product amount");
        tmpInt = ReadInput.UserStringInput();
        amount = (tmpInt.equals("")) ? -1 : Integer.parseInt(tmpInt);
        Print.printText("Product isAvailable ");
        tmpInt = ReadInput.UserStringInput();
        isAvailable = (tmpInt.equals("")) ? -1 : Integer.parseInt(tmpInt);
        Print.printText("Product category Id");
        tmpInt = ReadInput.UserStringInput();
        categoryId = (tmpInt.equals("")) ? -1 : Integer.parseInt(tmpInt);
        Print.printText("Product price");
        tmpFloat = ReadInput.UserStringInput();
        price = (tmpFloat.equals("")) ? (float) 0.0 : Float.parseFloat(tmpFloat);

        new ProductService().updateProduct(name, productName, amount, isAvailable, categoryId, price);

    }
}
