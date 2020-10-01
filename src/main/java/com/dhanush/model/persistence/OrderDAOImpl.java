package com.dhanush.model.persistence;

import com.dhanush.model.bean.Coffee;
import com.dhanush.model.bean.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public void insertOrder(Order order, int coffee_id, int size_id, int addon_id, int discount_id) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Coffee> coffees = new ArrayList<>();
        connection = DbConnection.getConnection();

        // Class.forName("com.mysql.cj.jdbc.Driver");
        //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "dhanush09");
        preparedStatement = connection.prepareStatement("insert into placeOrder(coffee_id,size_id,addon_id,discount_id)values(?,?,?,?);");
        preparedStatement.setInt(1, order.getCoffee_id());
        preparedStatement.setInt(2, order.getSize_id());
        preparedStatement.setInt(3, order.getAddon_id());
        preparedStatement.setInt(4, order.getDiscount_id());
        int check = preparedStatement.executeUpdate();
        if (check > 0) {
            System.out.println("Your Order has been placed, please pay your bill");
        } else {
            System.out.println("Something went wrong");
        }
        //connection.close();
    }
}
