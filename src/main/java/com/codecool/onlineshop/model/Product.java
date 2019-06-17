package com.codecool.onlineshop.model;

public class Product {
    private int id;
    private String name;
    private float price;
    private int amount;
    private int isAvailable;
    private int categoryId;

    public Product(int id, String name, int amount, int isAvailable, int categoryId, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.categoryId = categoryId;
    }
    public Product(String name, int amount, int isAvailable, int categoryId, float price) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {

        return id + " " + name + " " + price + " " + amount + " " + isAvailable + " " + categoryId;
    }
}
