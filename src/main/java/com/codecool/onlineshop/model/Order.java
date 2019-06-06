package com.codecool.onlineshop.model;

import java.util.Date;

public class Order {
    private int id_order;
    private String orderDate;
    private String payDate;
    private int id_owner;
    private int id_status;
    private int id_product;

    public Order(int id_order, String orderDate, String payDate, int id_owner, int id_status, int id_product) {
        this.id_order = id_order;
        this.orderDate = orderDate;
        this.payDate = payDate;
        this.id_owner = id_owner;
        this.id_status = id_status;
        this.id_product = id_product;
    }

    public Order(String orderDate, String payDate, int id_owner, int id_status, int id_product) {
        this.orderDate = orderDate;
        this.payDate = payDate;
        this.id_owner = id_owner;
        this.id_status = id_status;
        this.id_product = id_product;
    }

    public int getId_order() {
        return id_order;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getPayDate() {
        return payDate;
    }

    public int getId_owner() {
        return id_owner;
    }

    public int getId_status() {
        return id_status;
    }

    public int getId_product() {
        return id_product;
    }

    @Override
    public String toString() {
        return this.id_order + " " + this.orderDate + " " + this.payDate + " " + this.id_order + " " + this.id_status +
                " " + this.id_product + "\n";
    }
}