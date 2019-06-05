package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.dao.interfaces.Dao;
import com.codecool.onlineshop.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorySql implements Dao {

    private SqlImplementation sqlImplementation;

    public CategorySql() {
        sqlImplementation = new SqlImplementation();
    }

    @Override
    public void create(String... args) {
        sqlImplementation.doQuery(" INSERT INTO category(name, is_available) VALUES('"+args[0]+"', '"+Integer.parseInt(args[1])+"')");
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
                        resultSet.getString("name"), resultSet.getInt("is_available"));

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
    public void update() {

    }

    @Override
    public void delete() {
        //toDo:
        //doQuery("DELETE FROM category WHERE name = " + cateogryName + ";");

    }
}
