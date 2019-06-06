package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.dao.interfaces.Dao;
import com.codecool.onlineshop.model.Category;
import com.codecool.onlineshop.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements Dao<Order> {

    private SqlImplementation sqlImplementation;


    public OrderDao() {
        sqlImplementation = new SqlImplementation();
    }


    @Override
    public void create(Order obj) {
        sqlImplementation.doQuery(" INSERT INTO Orders(order_create, pay_date,id_owner,id_status,id_product)" +
                " VALUES('" + obj.getOrderDate() + "', '" + obj.getPayDate() + "', '" + obj.getId_owner() + "', '" +
                obj.getId_status() + "', '" + obj.getId_product() + "')");
        sqlImplementation.closeQuery();

    }

    @Override
    public List read() {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM Orders ";
        ResultSet resultSet = sqlImplementation.selectQuery(sql);
        try {
            while (resultSet.next()) {
                Order order = new Order(resultSet.getInt("id_order"),
                        resultSet.getString("order_create"),
                        resultSet.getString("pay_date"),
                        resultSet.getInt("id_owner"),
                        resultSet.getInt("id_status"),
                        resultSet.getInt("id_product"));

                orderList.add(order);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sqlImplementation.closeQuery();
        }
        return orderList;
    }

    @Override
    public void update() {

        //toDo: Implement

        try {
            throw new UnsupportedOperationException("not implementet yet");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {

        //toDo: Implement

        try {
            throw new UnsupportedOperationException("not implementet yet");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

    }
}
