package com.codecool.onlineshop.controller.services;

import com.codecool.onlineshop.dao.ProductDao;
import com.codecool.onlineshop.model.Product;

import java.util.List;

public class ProductService {
    ProductDao productDao;
    public ProductService() {
        productDao = new ProductDao();
    }


    public void create(String name, int amount, int is_available, int categoryId, float price) {
        productDao.create(new Product(name, price, amount, is_available, categoryId));
    }

    public List getAllProducts(){
        return productDao.read();
    }

    public Product getProductById(int productId){
        List<Product> productList = getAllProducts();
        for(Product product: productList){
            if (product.getId() == productId){
                return product;
            }
        }
        return null;
    }

    public void updateProduct(String name){
        List<Product> productList = getAllProducts();
        for(Product product : productList){
            if(product.getName().equals(name)){
                productDao.update(product);
            }
            System.out.println("Something went wrong!");
        }


    }
}
