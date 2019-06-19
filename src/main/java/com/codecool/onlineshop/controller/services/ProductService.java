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

    public Product getProductById(int productId) {
        List<Product> productList = getAllProducts();
        for (Product product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void updateProductName(int productId, String newProductName) {
        Product product = getProductById(productId);
        product.setName(newProductName);
        productDao.update(product);
    }

    public void updateProductAmount(int productId, int newAmount) {
        Product product = getProductById(productId);
        product.setAmount(newAmount);
        productDao.update(product);
    }

    public void updateProductIsAvailable(int productId, int isAvailable) {
        Product product = getProductById(productId);
        product.setIsAvailable(isAvailable);
        productDao.update(product);
    }

    public void updateProductCategory(int productId, int productCategory) {
        Product product = getProductById(productId);
        product.setCategoryId(productCategory);
        productDao.update(product);
    }

    public void updateProductPrice(int productId, float price) {
        Product product = getProductById(productId);
        product.setPrice(price);
        productDao.update(product);
    }

    public void deactivateProductWhenQuantityEquals0() {
        List<Product> productList;
        productList = getAllProducts();
        for (Product product : productList) {
            if (product.getAmount() == 0) {
                updateProductIsAvailable(product.getId(), 0);
            }
        }
    }

    public void updateProduct(String name, String productName, int amount, int is_available, int categoryId, float price) {
        List<Product> productList;
        productList = getAllProducts();

        for (Product product : productList) {
            if (product.getName().equals(name)) {
                int id = product.getId();
<<<<<<< HEAD
                if (!productName.equals("")) {
                    System.out.println("jestem tu");
                    System.out.println(product.getId());
                    updateProductName(id, productName);
=======
                if (!productName.equals("")){
                    System.out.println("jestem tu");
                    System.out.println(product.getId());
                    updateProductName(id,productName);
>>>>>>> 3e91eb916f07dcfe85df48b6786d7f7d2b3dc0fa
                }
                if (amount != -1) {
                    updateProductAmount(id, amount);
                }
                if (is_available != -1) {
                    updateProductIsAvailable(id, is_available);
                }
                if (categoryId != -1) {
                    updateProductCategory(id, categoryId);
                }
<<<<<<< HEAD
                if (price != 0.0) {
                    updateProductPrice(id, price);
=======
                if(price != 0.0){
                    updateProductPrice(id,price);
>>>>>>> 3e91eb916f07dcfe85df48b6786d7f7d2b3dc0fa
                }

            }
        }
    }
        public void deactivateProduct(int index){
            List<Product> productList;
            productList = getAllProducts();

            for(Product product : productList){
                if(product.getId() == index) {
                    updateProductIsAvailable(index,0);
                }
            }
        }
    }


