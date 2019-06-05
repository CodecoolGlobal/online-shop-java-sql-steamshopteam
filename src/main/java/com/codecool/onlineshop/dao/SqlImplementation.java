package com.codecool.onlineshop.dao;

import com.codecool.onlineshop.dao.interfaces.Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SqlImplementation implements Sql {
    ConnectToSql connect;
    Connection con;
    Statement statement;

    public SqlImplementation() {
        connect = new ConnectToSql();
    }


    public ResultSet selectQuery(String sql) {
        ResultSet resultSet = null;
        try {
            con = connect.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public void doQuery(String sql) {
        try {
            con = connect.connect();
            statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void closeQuery(){
        try {
            this.statement.close();
            this.con.close();
            this.connect.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
