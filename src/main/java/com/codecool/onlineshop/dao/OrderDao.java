package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.dao.interfaces.Dao;
import com.codecool.onlineshop.model.Order;

import java.util.List;

public class OrderDao implements Dao<Order> {


    @Override
    public void create(Order obj) {

    }

    @Override
    public List read() {
        return null;
    }

    @Override
    public void update() {

        //toDo: Implement

        try {
            throw new UnsupportedOperationException("not implementet yet");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete() {

        //toDo: Implement

        try {
            throw new UnsupportedOperationException("not implementet yet");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

    }
}
