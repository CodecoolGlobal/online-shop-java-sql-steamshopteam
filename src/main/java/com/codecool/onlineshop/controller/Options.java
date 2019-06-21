package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.BasketService;
import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.ConvertToArrays;
import com.codecool.onlineshop.model.Product;
import com.codecool.onlineshop.model.User;
import com.codecool.onlineshop.model.UserLogin;

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
    private BasketService basketService = new BasketService();

    private Product product = productService.getProductById(3);

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

    private Map<String, Consumer<Void>> getOptions()
    {
        Map<String, Consumer<Void>> options = new HashMap<>();

        options.put("1", (a) -> basketService.addProductToBasket(getUser(), product, 0));

        options.put("2", (a) -> System.out.println("showing basket"));

        options.put("3. Edit basket", (a) -> System.out.println("edit basket"));

        options.put("4. Delete from basket", (a) -> System.out.println("delete from basket"));

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

    void run(String filePath, String userChoice, User user) {

        setUser(user);

        try {
            loadOptions(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(userChoice != null)
            getOptions().get(userChoice).accept(null);
        else
            System.out.println("Error: UserChoice is null");
    }
}
