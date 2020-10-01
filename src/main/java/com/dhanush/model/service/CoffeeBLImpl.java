package com.dhanush.model.service;

import com.dhanush.model.bean.Coffee;
import com.dhanush.model.persistence.CoffeeDAO;
import com.dhanush.model.persistence.CoffeeImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeBLImpl implements CoffeeBL {

    private CoffeeDAO coffeeDAO = new CoffeeImpl();

    public ArrayList<Coffee> getAllCoffeeNames() throws ClassNotFoundException, SQLException {
        return coffeeDAO.getAllCoffee();

    }

    @Override
    public int getCoffeePrice(String name) throws ClassNotFoundException, SQLException {
        ArrayList<Coffee> coffeeArrayList1 = getAllCoffeeNames();
        for (Coffee coffee : coffeeArrayList1) {
            if (coffee.getCoffee_name().equalsIgnoreCase(name)) {
                return coffee.getCoffee_price();
            }

        }

        return 0;
    }

    @Override
    public int getCoffeePrice(int id) throws ClassNotFoundException, SQLException {
        ArrayList<Coffee> coffeeArrayList1 = getAllCoffeeNames();
        for (Coffee coffee : coffeeArrayList1) {
            if (coffee.getCoffee_id() == id) {
                return coffee.getCoffee_price();
            }

        }

        return 0;
    }


}
