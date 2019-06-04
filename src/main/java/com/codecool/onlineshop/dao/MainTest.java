package com.codecool.onlineshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest {
  public static void main(String[] atgs){


      try {

          ConnectToSql connect = new ConnectToSql();
          Connection con = connect.connect();
          Statement statement = con.createStatement();
          ResultSet resultSet = statement.executeQuery("SELECT * from Users");

          while (resultSet.next()){
              System.out.println(resultSet.getInt("id")
              + "\t" + resultSet.getString("password")  + "\t" +
                      resultSet.getString("name"));
          }
          connect.disconnect();

      } catch (SQLException e) {
          e.printStackTrace();
      }



  }
}
