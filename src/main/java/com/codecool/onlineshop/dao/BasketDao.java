package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.dao.interfaces.Dao;
import com.codecool.onlineshop.model.Basket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasketDao implements Dao<Basket> {
    private SqlImplementation sqlImplementation;


    public BasketDao() {
        sqlImplementation = new SqlImplementation();
    }

    @Override
    public void create(Basket basket) {
        sqlImplementation.doQuery("INSERT INTO baskets(ownerId, productId, amount) VALUES ('"+basket.getOwnerId()+"','"+basket.getProduct()+"', '"+basket.getAmount()+"')");
    }

    @Override
    public List read() {
        List<Basket> basketList = new ArrayList<>();
        ResultSet resultSet = sqlImplementation.selectQuery("SELECT * FROM baskets");
        try {
            while (resultSet.next()) {

                int ownerId = resultSet.getInt("ownerId");
                int productId = resultSet.getInt("productId");
                int amount = resultSet.getInt("amount");
                Basket basket = new Basket(ownerId, productId, amount);
                basketList.add(basket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return basketList;
    }

    @Override
    public void update(Basket basket) {
        try {
            sqlImplementation.doQuery("UPDATE baskets SET ownerId = '"+basket.getOwnerId()+"'," +
                    " productId = '"+basket.getProduct()+"', amount = '"+basket.getAmount()+"' WHERE productId = '"+basket.getProduct()+"'");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {
        sqlImplementation.doQuery("DELETE FROM baskets WHERE ownerId = '"+id+"'");

    }
}
