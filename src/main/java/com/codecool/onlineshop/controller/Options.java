package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.BasketService;
import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.ConvertToArrays;
import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.model.User;
import com.codecool.onlineshop.model.UserLogin;
import com.codecool.onlineshop.model.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

class Options {
    private ConvertToArrays converter = new ConvertToArrays();
    private ProductService productService = new ProductService();
    private BasketController basketController;
    private OrderController orderController;
    private ProductController productController;
    private CategoryController categoryController;

    private Product product = productService.getProductById(3);

    public Options(User user) {
        this.user = user;
        this.basketController = new BasketController(user);
        this.orderController = new OrderController(user);
        this.productController = new ProductController();
        this.categoryController = new CategoryController();
    }


    private User user;

    List<String> loadOptions(String filePath) throws IOException {
        List<String> options = new ArrayList<>();

        FileInputStream fstream = new FileInputStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        while ((strLine = br.readLine()) != null) {
            options.add(strLine);
        }

        fstream.close();

        return options;
    }

    private Map<String, Consumer<Void>> getOptions() {
        Map<String, Consumer<Void>> options = new HashMap<>();

        options.put("1", (a) -> basketController.addProductToBasket());

        options.put("2", (a) -> basketController.showUserBasket(user));

        options.put("3", (a) -> basketController.editBasket(user));

        options.put("4", (a) -> basketController.deleteProductFromBasket());

        options.put("5", (a) -> orderController.makeOrder());

        options.put("6", (a) -> orderController.showOrdersHistory());

        options.put("7", (a) -> productController.showAllProducts());

        options.put("8", (a) -> productController.showProductByCategory());

        options.put("9", (a) -> System.out.println("showing basket"));

        options.put("10. Rate product", (a) -> System.out.println("showing basket"));

        options.put("11. Order history statistics", (a) -> System.out.println("showing basket"));

        return options;
    }



    private Map<String, Consumer<Void>> getOptionsAdmin() {
        Map<String, Consumer<Void>> options = new HashMap<>();

        options.put("1", (a) -> categoryController.createNewCategory());

        options.put("2", (a) -> categoryController.editNameExistCategory());

        options.put("3", (a) -> productController.deactiveEmptyProduct());

        options.put("4", (a) -> productController.createNewProduct());

        options.put("5", (a) -> productController.updateProduct());

        options.put("6", (a) -> productController.deactivateProductOf());

        options.put("7", (a) -> productController.setDiscount());

        options.put("8", (a) -> System.out.println("print orders list"));

        return options;
    }

    void run(String filePath, String userChoice) {

        try {
            loadOptions(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (userChoice != null)
            getOptions().get(userChoice).accept(null);
        else
            System.out.println("Error: UserChoice is null");
        if(user.getPermission() != 1)
            getOptions().get(userChoice).accept(null);
        else
            getOptionsAdmin().get(userChoice).accept(null);
    }
}
