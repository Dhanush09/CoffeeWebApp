package com.dhanush.model.persistence;

import com.dhanush.model.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SizeDAOImpl implements SizeDAO {
    @Override
    public CoffeeSize getPrice(int id) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<CoffeeSize> coffeesize = new ArrayList<>();
        connection = DbConnection.getConnection();

        // Class.forName("com.mysql.cj.jdbc.Driver");
        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "dhanush09");
        preparedStatement = connection.prepareStatement("SELECT * FROM Size where size_id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        CoffeeSize coffeeSize = new CoffeeSize();
        while (resultSet.next()) {
           /* String name = resultSet.getString("size");
            int price = resultSet.getInt("size_price");
            //int id = resultSet.getInt("coffee_id");
            coffeeSize=new CoffeeSize(name,price);
            coffeesize.add(coffeeSize);*/
            coffeeSize.setSize_id(resultSet.getInt("size_id"));
            coffeeSize.setSize(resultSet.getString("size"));
            coffeeSize.setSize_price(resultSet.getInt("size_price"));
        }
        connection.close();
        return coffeeSize;

    }

    @Override
    public ArrayList<CoffeeSize> getAllSize() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<CoffeeSize> coffeesize = new ArrayList<>();
        connection = DbConnection.getConnection();

        // Class.forName("com.mysql.cj.jdbc.Driver");
        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "dhanush09");
        preparedStatement = connection.prepareStatement("SELECT * FROM Size");
        ResultSet resultSet = preparedStatement.executeQuery();
        CoffeeSize coffeeSize;
        while (resultSet.next()) {
            String name = resultSet.getString("size");
            int price = resultSet.getInt("size_price");
            int id = resultSet.getInt("size_id");
            coffeeSize = new CoffeeSize(name, price, id);
            coffeesize.add(coffeeSize);
        }
        connection.close();
        return coffeesize;
    }
}
