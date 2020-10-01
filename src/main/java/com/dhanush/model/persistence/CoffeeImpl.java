package com.dhanush.model.persistence;

import com.dhanush.model.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeImpl implements CoffeeDAO {

    @Override
    public ArrayList<Coffee> getAllCoffee() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Coffee> coffees = new ArrayList<>();
        connection = DbConnection.getConnection();

        // Class.forName("com.mysql.cj.jdbc.Driver");
        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "dhanush09");
        preparedStatement = connection.prepareStatement("SELECT * FROM coffee");
        ResultSet resultSet = preparedStatement.executeQuery();
        Coffee coffee;
        while (resultSet.next()) {
            String name = resultSet.getString("coffee_name");
            int price = resultSet.getInt("coffee_price");
            int id = resultSet.getInt("coffee_id");
            coffee = new Coffee(name, id, price);
            coffees.add(coffee);
        }
        connection.close();
        return coffees;
    }

    @Override
    public Coffee getCoffeePrice(int id) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Coffee> coffees = new ArrayList<>();
        connection = DbConnection.getConnection();

        // Class.forName("com.mysql.cj.jdbc.Driver");
        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "dhanush09");
        preparedStatement = connection.prepareStatement("SELECT * FROM coffee where coffee_id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Coffee coffee = new Coffee();
        while (resultSet.next()) {

            coffee.setCoffee_id(resultSet.getInt("coffee_id"));
            coffee.setCoffee_name(resultSet.getString("coffee_name"));
            coffee.setCoffee_price(resultSet.getInt("coffee_price"));
        }
        connection.close();
        return coffee;


    }

    @Override
    public Coffee getCoffeePrice(String name) throws ClassNotFoundException, SQLException {

        return null;
    }
}
