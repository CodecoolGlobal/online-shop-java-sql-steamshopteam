package com.codecool.onlineshop.model;

import com.codecool.onlineshop.view.Viewer;

import java.util.ArrayList;
import java.util.List;



public class ConvertToArrays {

    private Viewer viewer = new Viewer();

    public void sendProductsToTable(List<Product> incomingData)
    {
        List<List<String>> productsList = new ArrayList<>();

        int counter = 0;
        for (Product product : incomingData)
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

}
