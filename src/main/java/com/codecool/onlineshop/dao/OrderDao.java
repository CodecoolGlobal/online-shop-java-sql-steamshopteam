package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.dao.interfaces.Dao;
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
    public void create(Order order) {
        sqlImplementation.doQuery(" INSERT INTO orders(order_create, pay_date,id_owner,id_status,id_product)" +
                " VALUES('" + order.getOrderDate() + "', '" + order.getPayDate() + "', '" + order.getId_owner() + "', '" +
                order.getId_status() + "', '" + order.getId_product() + "')");
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
                        resultSet.getInt("id_product"),
                        resultSet.getInt("amount"));

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
    public void update(Order order) {


        try {
            sqlImplementation.doQuery("UPDATE orders SET order_create = '"+order.getOrderDate()+"'," +
                    " pay_date = '"+order.getPayDate()+"', id_owner = '"+order.getId_owner()+"', id_status = '"+order.getId_status()+"'," +
                    " id_product = '"+order.getId_product()+"' WHERE id_owner = '"+order.getId_owner()+"'");
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
