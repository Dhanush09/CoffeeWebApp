package com.dhanush.model.service;

import com.dhanush.model.bean.Discount;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DiscountBL {
    ArrayList<Discount> getFinalDiscount() throws ClassNotFoundException, SQLException;

    public int getDiscountValue(String dis) throws ClassNotFoundException, SQLException;
}
