package com.dhanush.model.service;

import com.dhanush.model.bean.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBL {
    public int calculateBill(Order order) throws ClassNotFoundException, SQLException;

    public ArrayList getDetails(Order order) throws ClassNotFoundException, SQLException;

    public int getBill(Order order) throws ClassNotFoundException, SQLException;
}
