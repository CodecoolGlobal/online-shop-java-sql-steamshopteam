package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.dao.interfaces.Dao;
import com.codecool.onlineshop.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Product> {
    private SqlImplementation sqlImplementation;

    public ProductDao() {
        sqlImplementation = new SqlImplementation();
    }


    @Override
    public void create(Product product) {
        sqlImplementation.doQuery("INSERT INTO products(name, amount, is_avaible, id_category, price) VALUES ('" + product.getName() + "','" + product.getAmount() + "','" + product.getIsAvailable() + "','" + product.getCategoryId() + "','" + product.getPrice() + "')");

    }

    @Override
    public List read() {
        List<Product> products = new ArrayList<>();
        ResultSet resultSet = sqlImplementation.selectQuery("SELECT * FROM products");
        try {
            while (resultSet.next()) {

                int productId = resultSet.getInt("id_product");
                String name = resultSet.getString("name");
                int amount = resultSet.getInt("amount");
                int isAvailable = resultSet.getInt("is_avaible");
                int idCategory = resultSet.getInt("id_category");
                int price = resultSet.getInt("price");
                Product product = new Product(productId, name, amount, isAvailable, idCategory, price);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    @Override
    public void update(Product product) {
        try {
            sqlImplementation.doQuery("UPDATE products SET name = '" + product.getName() + "'," +
                    " amount = '" + product.getAmount() + "', is_avaible = '" + product.getIsAvailable() + "'," +
                    " id_category = '" + product.getCategoryId() + "', price = '" + product.getPrice() + "' WHERE " +
                    "id_product = '" + product.getId() + "'");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void delete(int id) {

    }
}