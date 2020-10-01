package com.dhanush.model.persistence;

import com.dhanush.model.bean.CoffeeSize;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SizeDAO {
    ArrayList<CoffeeSize> getAllSize() throws ClassNotFoundException, SQLException;

    CoffeeSize getPrice(int id) throws ClassNotFoundException, SQLException;
}
