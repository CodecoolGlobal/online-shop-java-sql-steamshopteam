package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.BasketService;
import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.ConvertToArrays;
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
    private ProductController productController = new ProductController();
    private BasketService basketService = new BasketService();
    private CategoryController categoryController = new CategoryController();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    List<String> loadOptions(String filePath) throws IOException
    {
        List<String> options = new ArrayList<>();

        FileInputStream fstream = new FileInputStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        while ((strLine = br.readLine()) != null)   {
            options.add(strLine);
        }

        fstream.close();

        return options;
    }

    private Map<String, Consumer<Void>> getOptionsCustomer()
    {
        Map<String, Consumer<Void>> options = new HashMap<>();
        //add to basket
        options.put("1", (a) -> {
            converter.sendProductsToTable(productService.getAllProducts());
            basketService.addProductToBasket(getUser(), productService.getProductById(ReadInput.UserIntInput()),
                    ReadInput.UserIntInput());
        });
        //show basket
        options.put("2", (a) -> converter.sendBasketToTable(basketService.showAllBaskets()));
        //edit basket
        options.put("3", (a) -> basketService.editBasket(user,
                productService.getProductByName(ReadInput.UserStringInput()),
                ReadInput.UserStringInput(),
                ReadInput.UserIntInput()));
        //delete basket
        options.put("4", (a) -> basketService.deleteProductFromBasket(user,
                productService.getProductByName(ReadInput.UserStringInput())));

        options.put("5. Place order", (a) -> System.out.println("placing order"));

        options.put("6. Show orders history", (a) -> System.out.println("showing orders history"));

        options.put("7", (a) -> {
            converter.sendProductsToTable(productService.getAllProducts());
        });

        options.put("8", (a) -> System.out.println("showing basket"));

        options.put("9", (a) -> System.out.println("showing basket"));

        options.put("10. Rate product", (a) -> System.out.println("showing basket"));

        options.put("11. Order history statistics", (a) -> System.out.println("showing basket"));

        return options;
    }

    private Map<String, Consumer<Void>> getOptionsAdmin()
    {
        Map<String, Consumer<Void>> options = new HashMap<>();

        options.put("1", (a) -> categoryController.createNewCategory());

        options.put("2", (a) -> categoryController.editNameExistCategory());

        options.put("3", (a) -> productController.deactiveEmptyProduct());

        options.put("4", (a) -> productController.createNewProduct());

        options.put("5", (a) -> productController.updateProduct());

        options.put("6", (a) -> System.out.println("deactive product"));

        options.put("7", (a) -> productController.setDiscount());

        options.put("8", (a) -> System.out.println("print orders list"));

        return options;
    }

    void run(String filePath, String userChoice, User user) {

        setUser(user);

        try {
            loadOptions(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(user.getPermission() != 1)
            getOptionsCustomer().get(userChoice).accept(null);
        else
            getOptionsAdmin().get(userChoice).accept(null);
    }
}
