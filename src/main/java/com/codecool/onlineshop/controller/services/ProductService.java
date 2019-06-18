package com.codecool.onlineshop.controller.services;

import com.codecool.onlineshop.dao.ProductDao;
import com.codecool.onlineshop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    ProductDao productDao;

    public ProductService() {
        productDao = new ProductDao();
    }


    public void create(String name, int amount, int is_available, int categoryId, float price) {
        productDao.create(new Product(name, amount, is_available, categoryId, price));
    }

    public List getAllProducts() {
        return productDao.read();
    }

    public Product getProductByName(String productName) {
        List<Product> productList = getAllProducts();
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public void updateProductName(String productName, String newProductName) {
        Product product = getProductByName(productName);
        product.setName(newProductName);
        productDao.update(product);
    }

    public void updateProductAmount(String productName, int newAmount) {
        Product product = getProductByName(productName);
        product.setAmount(newAmount);
        productDao.update(product);
    }

    public void updateProductIsAvailable(String productName, int isAvailable) {
        Product product = getProductByName(productName);
        product.setIsAvailable(isAvailable);
        productDao.update(product);
    }

    public void updateProductCategory(String productName, int productCategory) {
        Product product = getProductByName(productName);
        product.setCategoryId(productCategory);
        productDao.update(product);
    }

    public void updateProductPrice(String productName, float price) {
        Product product = getProductByName(productName);
        product.setPrice(price);
        productDao.update(product);
    }

    public void deactivateProductWhenQuantityEquals0() {
        List<Product> productList;
        productList = getAllProducts();
        for (Product product : productList) {
            if (product.getAmount() == 0) {
                updateProductIsAvailable(product.getName(), 0);
            }
        }
    }

}
