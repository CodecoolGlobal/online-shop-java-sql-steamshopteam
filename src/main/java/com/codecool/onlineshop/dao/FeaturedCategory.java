package com.codecool.onlineshop.dao;

import java.util.Date;

public class FeaturedCategory extends Category {
    private Date expirationDate;

    public FeaturedCategory(int id, String name, int isAvailable, Date expirationDate) {
        super(id, name, isAvailable);
        this.expirationDate = expirationDate;
    }
}
