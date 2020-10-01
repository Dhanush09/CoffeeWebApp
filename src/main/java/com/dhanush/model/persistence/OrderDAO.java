package com.dhanush.model.persistence;

import java.sql.SQLException;

import com.dhanush.model.bean.*;

public interface OrderDAO {
    void insertOrder(Order order, int coffee_id, int size_id, int addon_id, int discount_id) throws ClassNotFoundException, SQLException;
}
