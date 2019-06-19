package com.codecool.onlineshop.controller;

import com.codecool.onlineshop.controller.services.ProductService;
import com.codecool.onlineshop.model.ConvertToArrays;
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
    UserLogin userLogin;

    ConvertToArrays converter = new ConvertToArrays();
    ProductService productService = new ProductService();

    List<String> loadOptions(String filePath) throws IOException {
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

    private Map<String, Consumer<Void>> getOptions(){
        Map<String, Consumer<Void>> options = new HashMap<>();
        options.put("1", (a) -> System.out.println("add to basket"));

        options.put("2. Show basket", (a) -> System.out.println("showing basket"));

        options.put("3. Edit basket", (a) -> System.out.println("edit basket"));

        options.put("4. Delete from basket", (a) -> System.out.println("delete from basket"));

        options.put("5. Place order", (a) -> System.out.println("placing order"));

        options.put("6. Show orders history", (a) -> System.out.println("showing orders history"));

        options.put("7. Show available products", (a) -> {
            converter.sendProductsToTable(productService.getAllProducts());
        });

        options.put("8. Show product in category", (a) -> System.out.println("showing basket"));

        options.put("9. Show products availability", (a) -> System.out.println("showing basket"));

        options.put("10. Rate product", (a) -> System.out.println("showing basket"));

        options.put("11. Order history statistics", (a) -> System.out.println("showing basket"));

        return null;
    }

    void run(String filePath, String userChoice) {
        try {
            loadOptions(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        getOptions().get(userChoice).accept(null);
    }
}
