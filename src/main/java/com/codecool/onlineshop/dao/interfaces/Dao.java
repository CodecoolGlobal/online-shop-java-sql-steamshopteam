package com.codecool.onlineshop.dao.interfaces;

import java.util.List;

public interface Dao <T> {

    void create(T obj);
    //void create(T obj, T obj1);
    List read();
    void update();
    void delete(int id);
}
