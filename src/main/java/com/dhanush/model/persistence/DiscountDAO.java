package com.dhanush.model.persistence;

import com.dhanush.model.bean.Discount;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DiscountDAO {
    ArrayList<Discount> getAllDiscount() throws ClassNotFoundException, SQLException;

    Discount searchDiscount(int id) throws ClassNotFoundException, SQLException;
}
