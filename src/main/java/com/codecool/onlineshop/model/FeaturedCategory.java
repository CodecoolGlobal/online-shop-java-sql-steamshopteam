package com.codecool.onlineshop.model;

import java.util.Date;

public class FeaturedCategory extends Category {
    private Date expirationDate;

    public FeaturedCategory(int id, String name, int isAvailable, Date expirationDate) {
        super(id, name);
        this.expirationDate = expirationDate;
    }
}
