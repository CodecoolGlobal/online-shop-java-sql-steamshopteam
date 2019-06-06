package com.codecool.onlineshop.view;

import com.codecool.onlineshop.dao.Product;

import java.util.ArrayList;
import java.util.List;

public class Viewer {

    public void displayTable(List<List<String>> table){
        List<String> headers = new ArrayList<>();
        headers.add("ID");
        headers.add("NAME");
        headers.add("PRICE");
        headers.add("AMOUNT");
        headers.add("isAVAILABLE");
        headers.add("CATEGORY");
        PrintTable newTable = new PrintTable(headers,  table , false);
        String tableToPrint = newTable.printTable();
        display(tableToPrint);
    }

    public void display(String content){
        System.out.println(content);
    }

    public List<List<String>> productsToString(List<Product> products){
        List<List<String>> list = new ArrayList<>();
        for (Product product : products) {
            List<String> temp = new ArrayList<>();
            temp.add(product.getId().toString());
            temp.add(product.getName());
            temp.add(product.getPrice().toString());
            temp.add(product.getAmount().toString());
            temp.add(product.getAvailable().toString());
            temp.add(product.getCategory().getName());

            list.add(temp);
        }
        return list;
    }
}
