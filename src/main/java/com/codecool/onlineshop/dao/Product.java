package com.codecool.onlineshop.dao;

public class Product {
    private Integer id;
    private String name;
    private Float price;
    private Integer amount;
    private Boolean isAvailable;
    private Category category;

    public Product(Integer id, String name, Float price, Integer amount, Boolean isAvailable, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public Category getCategory() {
        return category;
    }

    public String ToString()
    {
        String txt = "";

        return txt;
    }
}
