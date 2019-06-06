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
        //bolean - 2
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
        sqlImplementation.doQuery("UPDATE category SET name = '"+obj.getName() +"' WHERE id_category = '" + obj.getId() + "' ");
        sqlImplementation.closeQuery();
    }

    @Override
    public void delete() {

        //toDo: Implement

        try {
            throw new UnsupportedOperationException("not implementet yet");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
