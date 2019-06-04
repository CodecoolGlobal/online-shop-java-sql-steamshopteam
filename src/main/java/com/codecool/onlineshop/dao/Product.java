package com.codecool.onlineshop.dao;

public class Product {
    private int id;
    private String name;
    private float price;
    private int amount;
    private boolean isAvailable;
    private Category category;

    public Product(int id, String name, float price, int amount, boolean isAvailable, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.category = category;
    }

    public String ToString()
    {
        String txt = "";

        return txt;
    }
}
