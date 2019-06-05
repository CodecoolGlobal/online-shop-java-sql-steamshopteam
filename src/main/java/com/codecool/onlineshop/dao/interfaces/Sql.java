package com.codecool.onlineshop.dao.interfaces;

import java.sql.ResultSet;

public interface Sql {
    ResultSet selectQuery(String sql);
    void doQuery(String sql);
    void closeQuery();
}
