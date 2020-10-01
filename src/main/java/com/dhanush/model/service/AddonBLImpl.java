package com.dhanush.model.service;

import com.dhanush.model.bean.CoffeeAddOns;
import com.dhanush.model.persistence.AddonDAO;
import com.dhanush.model.persistence.AddonDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddonBLImpl implements AddonBL {
    private AddonDAO addonDAO = new AddonDAOImpl();

    @Override
    public ArrayList<CoffeeAddOns> getAllCoffeeAddons() throws ClassNotFoundException, SQLException {

        return addonDAO.getAllAddons();

    }

    @Override
    public int getAddonPrice(String addon) throws ClassNotFoundException, SQLException {
        ArrayList<CoffeeAddOns> coffeeAddOnsArrayList = getAllCoffeeAddons();

        for (CoffeeAddOns coffeeAddOns : coffeeAddOnsArrayList) {
            if (coffeeAddOns.getAddon().equalsIgnoreCase(addon)) {
                return coffeeAddOns.getAddon_price();
            }
        }
        return 0;
    }

}
