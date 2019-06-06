package com.codecool.onlineshop.model;

public class Product {
    private int id;
    private String name;
    private float price;
    private int amount;
    private int isAvailable;
    private int categoryId;

    public Product(int id, String name, float price, int amount, int isAvailable, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.categoryId = categoryId;
    }
    public Product(String name, float price, int amount, int isAvailable, int categoryId) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String ToString()
    {
        String txt = "";

        return txt;
    }
}
