package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private boolean isAvailable;
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void GetProducts(List<Product> products)
    {

    }

    public String getName() {
        return name;
    }

    public String ToString()
    {
        String txt = "";

        return txt;
    }
}
