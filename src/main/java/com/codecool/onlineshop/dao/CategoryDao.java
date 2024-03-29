package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.dao.interfaces.Dao;
import com.codecool.onlineshop.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements Dao<Category> {

    private SqlImplementation sqlImplementation;


    public CategoryDao() {
        sqlImplementation = new SqlImplementation();
    }

    @Override
    public void create(Category obj) {
        sqlImplementation.doQuery(" INSERT INTO category(name) VALUES('" + obj.getName() +
                "')");
        sqlImplementation.closeQuery();

    }

    @Override
    public List read() {
        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT * FROM category ";
        ResultSet resultSet = sqlImplementation.selectQuery(sql);
        try {
            while (resultSet.next()) {
                Category category = new Category(resultSet.getInt("id_category"),
                        resultSet.getString("name"));

                categoryList.add(category);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sqlImplementation.closeQuery();
        }
        return categoryList;

    }

    @Override
    public void update(Category obj) {

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
