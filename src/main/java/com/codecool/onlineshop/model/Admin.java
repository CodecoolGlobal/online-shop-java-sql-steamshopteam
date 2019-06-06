package com.codecool.onlineshop.model;

import com.codecool.onlineshop.dao.CategoryDao;

public class Admin extends User {

    CategoryDao categoryDao = new CategoryDao();

    public Admin(int userId, String userName, String password, int permission) {
        super(userId, userName, password, permission);
    }

    private void addNewCategory()
    {
        categoryDao.create(new Category(0, "Test"));
    }

    private void editCategoryName(int categoryId)
    {

    }

    private void autoDeactiveProduct(int productId)
    {

    }

    public void createNewProduct()
    {

    }

    public void editProductProperties(int productId)
    {

    }

    public void deactiveProduct(int productId)
    {

    }

    public void createDiscount(int productId)
    {

    }

    public void showOrderList()
    {

    }

    public void showOrderFeedback()
    {

    }
}
