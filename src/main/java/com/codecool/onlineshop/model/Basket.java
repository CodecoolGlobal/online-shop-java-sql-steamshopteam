package com.codecool.onlineshop.model;

public class Basket {
    private int ownerId;
    private int productId;
    private int amount;

    public Basket(int ownerId, int productId, int amount) {
        this.ownerId = ownerId;
        this.productId = productId;
        this.amount = amount;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getProduct() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }
}
