package com.dhanush.model.service;

import com.dhanush.model.bean.CoffeeSize;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SizeBL {
    ArrayList<CoffeeSize> getAllCoffeeSize() throws ClassNotFoundException, SQLException;

    public int getSizePrice(String size) throws ClassNotFoundException, SQLException;
}
