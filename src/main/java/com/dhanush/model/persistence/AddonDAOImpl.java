package com.dhanush.model.persistence;

import com.dhanush.model.bean.CoffeeAddOns;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddonDAOImpl implements AddonDAO {
    @Override
    public ArrayList<CoffeeAddOns> getAllAddons() throws ClassNotFoundException, SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<CoffeeAddOns> coffeeAddOns = new ArrayList<>();
        connection = DbConnection.getConnection();

        // Class.forName("com.mysql.cj.jdbc.Driver");
        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "dhanush09");
        preparedStatement = connection.prepareStatement("SELECT * FROM AddOns");
        ResultSet resultSet = preparedStatement.executeQuery();
        CoffeeAddOns coffeeAddOns1;
        while (resultSet.next()) {
            String addonsName = resultSet.getString("addons");
            int addonsPrice = resultSet.getInt("addons_price");
            int id = resultSet.getInt("addon_id");
            coffeeAddOns1 = new CoffeeAddOns(addonsName, addonsPrice, id);
            coffeeAddOns.add(coffeeAddOns1);
        }
        connection.close();
        return coffeeAddOns;


    }

    @Override
    public CoffeeAddOns searchAddOns(int addonID) throws ClassNotFoundException, SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<CoffeeAddOns> coffeeAddOns = new ArrayList<>();
        connection = DbConnection.getConnection();

        // Class.forName("com.mysql.cj.jdbc.Driver");
        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "dhanush09");
        preparedStatement = connection.prepareStatement("SELECT * FROM AddOns where addon_id=?");
        preparedStatement.setInt(1, addonID);
        ResultSet resultSet = preparedStatement.executeQuery();

        CoffeeAddOns coffeeAddOns1 = new CoffeeAddOns();
        while (resultSet.next()) {
           /* String addonsName = resultSet.getString("addons");
            int addonsPrice = resultSet.getInt("addons_price");
            //int id = resultSet.getInt("coffee_id");
            coffeeAddOns1=new CoffeeAddOns(addonsName,addonsPrice);
            coffeeAddOns.add(coffeeAddOns1);*/
            coffeeAddOns1.setAddon_id(resultSet.getInt("addon_id"));
            coffeeAddOns1.setAddon(resultSet.getString("addons"));
            coffeeAddOns1.setAddon_price(resultSet.getInt("addons_price"));
            coffeeAddOns.add(coffeeAddOns1);
        }
        connection.close();

        return coffeeAddOns1;

    }
}
