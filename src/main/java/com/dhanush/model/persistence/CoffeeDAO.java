package com.dhanush.model.persistence;

import com.dhanush.model.bean.*;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CoffeeDAO {
    ArrayList<Coffee> getAllCoffee() throws ClassNotFoundException, SQLException;

    Coffee getCoffeePrice(String name) throws ClassNotFoundException, SQLException;

    Coffee getCoffeePrice(int id) throws ClassNotFoundException, SQLException;

}
