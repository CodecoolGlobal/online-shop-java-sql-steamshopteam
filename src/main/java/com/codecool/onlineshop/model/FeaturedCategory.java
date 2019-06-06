package com.codecool.onlineshop.model;

import java.util.Date;

public class FeaturedCategory extends Category {
    private Date expirationDate;

    public FeaturedCategory(String name) {
        super(name);
    }

    public FeaturedCategory(int id, String name) {
        super(id, name);
    }
}


