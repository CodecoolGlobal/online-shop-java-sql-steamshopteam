package com.codecool.onlineshop.model;

import com.codecool.onlineshop.dao.CategoryDao;
import com.codecool.onlineshop.dao.ProductDao;

public class Admin extends User {

    CategoryDao categoryDao = new CategoryDao();
    ProductDao productDao = new ProductDao();


    private void addNewCategory()
    {
        categoryDao.create(new Category(0, ""));
    }

    private void editCategoryName(int categoryId)
    {

    }

    private void autoDeactiveProduct(int productId)
    {

    }

    public void createNewProduct()
    {
        productDao.create(new Product(0, "", 0, 0, 0, 0));
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
