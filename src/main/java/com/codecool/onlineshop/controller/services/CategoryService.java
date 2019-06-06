package com.codecool.onlineshop.controller.services;

import com.codecool.onlineshop.dao.CategoryDao;
import com.codecool.onlineshop.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private CategoryDao categoryDao;

    public CategoryService() {
        categoryDao = new CategoryDao();
    }


    public void create(String categoryName) {
        categoryDao.create(new Category(categoryName));
    }

    public void update(int index, String name) {
        List<Category> categoryList = new ArrayList<>();
        categoryList = categoryDao.read();

        for(Category category : categoryList){
            if(category.getId() == index){

            }

        }

    }

}
