package com.codecool.onlineshop.view;

import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.model.UserInput;
import com.codecool.onlineshop.model.UserLogin;

import java.util.ArrayList;
import java.util.List;

public class UI {

    private UserInput input = new UserInput();
    private UserLogin userLogin = new UserLogin();
    private Viewer viewer = new Viewer();

    public void start(boolean isLogged) {
        showMenu(isLogged);
    }

    private void showMenu(boolean isLogged)
    {

        if(isLogged)
            showShopMenu();
        else
            showLoginMenu();
    }

    private void showLoginMenu()
    {
        System.out.println("1. Login\n2. Exit");
        int choice = Integer.parseInt(input.input());

        switch (choice)
        {
            case 1:
                userLogin.login();
            case 2:
                System.exit(0);
        }
    }

    private void sendProductsToTable()
    {
        ProductService productService = new ProductService();

        List<List<String>> productsList = new ArrayList<>();
        List<Product> products;

        products = productService.getAllProducts();

        int counter = 0;
        for (Product product : products)
        {
            productsList.add(new ArrayList<>());

            productsList.get(counter).add(String.valueOf(product.getId()));
            productsList.get(counter).add(product.getName());
            productsList.get(counter).add(String.valueOf(product.getPrice()));
            productsList.get(counter).add(String.valueOf(product.getAmount()));
            productsList.get(counter).add(String.valueOf(product.getIsAvailable()));
            productsList.get(counter).add(String.valueOf(product.getCategoryId()));

            counter += 1;
        }

        viewer.displayTable(productsList);
    }

    private void menuSwitch(int choice)
    {
        switch (choice)
        {
            case 1:
                System.out.println("1");
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                sendProductsToTable();
            case 8:
            case 9:
            case 10:
            case 11:
        }
    }

    private void showShopMenu()
    {
        System.out.println("1. Add product to basket\n" +
                "2. Show basket\n" +
                "3. Edit basket\n" +
                "4. Delete from basket\n" +
                "5. Place order\n" +
                "6. Show order history\n" +
                "7. Show available products\n" +
                "8. Show product in category\n" +
                "9. Show products availability\n" +
                "10. Rate product\n" +
                "11. Order history statistics\n");

        int choice = Integer.parseInt(input.input());
        menuSwitch(choice);
    }

    private void showAdminPanel()
    {
        System.out.println("1. Add new category\n" +
                "2. Edit category\n" +
                "3. Automatic deactive product\n" +
                "4. Create new product\n" +
                "5. Edit product properties\n" +
                "6. Deactive product\n" +
                "7. Create discount\n" +
                "8. Show orders list\n" +
                "9. Show orders feedbacks\n");

        int choice = Integer.parseInt(input.input());
        menuSwitch(choice);
    }
}
