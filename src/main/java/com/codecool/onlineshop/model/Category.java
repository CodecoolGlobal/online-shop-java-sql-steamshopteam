package com.codecool.onlineshop.model;

public class Category {
    private int id;
    private String name;
    private int isAvailable;

    public Category(int id, String name, int isAvailable) {
        this.id = id;
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.isAvailable;
    }
}
