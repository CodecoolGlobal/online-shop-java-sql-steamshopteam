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


    public List readAllCategory() {
        return categoryDao.read();

    }

    public Category readOf(int index) {
        List<Category> categoryList = categoryDao.read();
        Category cat = new Category();

        for (Category category : categoryList) {
            if (category.getId() == index) {
                cat = category;
            }
        }
        return cat;
    }

    public void create(String categoryName) {
        categoryDao.create(new Category(categoryName));
    }

    public void update(int index, String name) {
        List<Category> categoryList;
        categoryList = categoryDao.read();

            for (Category category : categoryList) {
                if (category.getId() == index) {
                    category.setName(name);
                    categoryDao.update(category);
                }
            }
    }

    public boolean indexExist(int index, List<Category> categoryList) {
        for (Category category : categoryList) {
            if (category.getId() == index)
                return true;
        }

        return false;

    }
}
