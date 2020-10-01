package com.dhanush.model.service;

import com.dhanush.model.bean.Coffee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CoffeeBL {
    ArrayList<Coffee> getAllCoffeeNames() throws ClassNotFoundException, SQLException;


    public int getCoffeePrice(String name) throws ClassNotFoundException, SQLException;

    public int getCoffeePrice(int id) throws ClassNotFoundException, SQLException;
}
