package com.dhanush.model.persistence;

import com.dhanush.model.bean.CoffeeAddOns;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddonDAO {
    ArrayList<CoffeeAddOns> getAllAddons() throws ClassNotFoundException, SQLException;

    CoffeeAddOns searchAddOns(int addonID) throws ClassNotFoundException, SQLException;
}
