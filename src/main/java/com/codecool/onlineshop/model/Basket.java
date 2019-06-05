package com.codecool.onlineshop.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket {
    private int id;
    private Iterator iterator;
    private List<Product> products = new ArrayList<>();

    public Iterator getIterator()
    {
        return iterator;
    }

    public void addProduct(Product product, int amount)
    {

    }

    public void deleteProduct(Product product)
    {

    }
}
