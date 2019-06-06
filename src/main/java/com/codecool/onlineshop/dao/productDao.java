package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.dao.interfaces.Dao;
import com.codecool.onlineshop.model.Product;

import java.util.List;

public class productDao implements Dao<Product> {


    @Override
    public void create(Product obj) {

    }

    @Override
    public List read() {
        return null;
    }


    @Override
    public void update(Product obj) {

        //toDo: Implement

        try {
            throw new UnsupportedOperationException("not implementet yet");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {

        //toDo: Implement

        try {
            throw new UnsupportedOperationException("not implementet yet");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

    }
}
