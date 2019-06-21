package com.codecool.onlineshop.controller.services;

import com.codecool.onlineshop.dao.ProductDao;
import com.codecool.onlineshop.model.Category;
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

    public Product getProductByName(String productName) {
        List<Product> productList = getAllProducts();
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    private List<Product> getProducts() {
        List<Product> productList;
        productList = getAllProducts();
        return productList;
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
        List<Product> productList = getProducts();
        for (Product product : productList) {
            if (product.getAmount() == 0) {
                updateProductIsAvailable(product.getId(), 0);
            }
        }
    }

    public void updateProduct(String name, String productName, int amount, int is_available, int categoryId, float price) {
        List<Product> productList = getProducts();

        for (Product product : productList) {
            if (product.getName().equals(name)) {
                int id = product.getId();
                if (!productName.equals("")) {
                    updateProductName(id, productName);
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
                if (price != 0.0) {
                    updateProductPrice(id, price);
                }

            }
        }

    }

    public void discountProduct(int index, int discount) {
        List<Product> productList = getProducts();
        float dis = (float) discount / 100;
        for (Product product : productList) {
            if (product.getId() == index) {
                updateProductPrice(product.getId(), (product.getPrice() - (product.getPrice() * dis)));
            }
        }


    }

    public List getProductByCategory(String categoryName){
        List<Product> productList = getAllProducts();
        List<Product> productsByCategoryName = new ArrayList<>();
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.readAllCategory();
        for(Product product : productList){
            for(Category category : categoryList){
                if(category.getName().equals(categoryName)){
                    if(category.getId() == product.getCategoryId()) {
                        productsByCategoryName.add(product);
                    }
                }
            }
        }
        return productsByCategoryName;
    }

    public List<Product> getAvailableProduct() {
        List<Product> productList = getProducts();
        List<Product> filteredProduct = new ArrayList<>();

        for(Product product : productList) {
            if(product.getIsAvailable() == 1)
                filteredProduct.add(product);
        }
        return filteredProduct;

    }

    public void deactivateProductOf(int index){
        List<Product> productList = getProducts();

        for(Product product : productList)
            if(product.getId() == index) {
                updateProductIsAvailable(product.getId(),0);
            }

    }
}
