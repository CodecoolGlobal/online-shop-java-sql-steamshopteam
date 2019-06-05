package com.codecool.onlineshop.dao.interfaces;

import java.util.List;

public interface Dao {

    void create(String... args);
    List read();
    void update();
    void delete();
}
