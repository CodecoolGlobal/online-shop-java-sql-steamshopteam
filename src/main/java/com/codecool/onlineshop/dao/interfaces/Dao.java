package com.codecool.onlineshop.dao.interfaces;

import java.util.List;

public interface Dao <T> {

    void create(T obj);
    List read();
    void update(T obj);
    void delete(int id);
}
