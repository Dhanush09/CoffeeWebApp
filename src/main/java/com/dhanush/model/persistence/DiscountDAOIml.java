package com.dhanush.model.persistence;

import com.dhanush.model.bean.Discount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiscountDAOIml implements DiscountDAO {
    @Override
    public ArrayList<Discount> getAllDiscount() throws ClassNotFoundException, SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Discount> coffeediscount = new ArrayList<>();
        connection = DbConnection.getConnection();

        preparedStatement = connection.prepareStatement("SELECT * FROM Discount");
        ResultSet resultSet = preparedStatement.executeQuery();
        Discount discount;
        while (resultSet.next()) {
            String couponcode = resultSet.getString("dis_code");
            int couponvalue = resultSet.getInt("discount");
            //int id = resultSet.getInt("coffee_id");
            discount = new Discount(couponcode, couponvalue);
            coffeediscount.add(discount);
        }
        connection.close();
        return coffeediscount;


    }

    @Override
    public Discount searchDiscount(int id) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Discount discount = new Discount();
        ArrayList<Discount> coffeediscount = new ArrayList<>();
        connection = DbConnection.getConnection();

        preparedStatement = connection.prepareStatement("SELECT * FROM Discount where discount_id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            /*String couponcode = resultSet.getString("dis_code");
            int couponvalue = resultSet.getInt("discount");
            //int id = resultSet.getInt("coffee_id");
            discount=new Discount(couponcode,couponvalue);
            coffeediscount.add(discount);*/
            discount.setDiscount_id(resultSet.getInt("discount_id"));
            discount.setCode(resultSet.getString("dis_code"));
            discount.setDiscount(resultSet.getInt("discount"));
        }
        connection.close();
        return discount;

    }

}
