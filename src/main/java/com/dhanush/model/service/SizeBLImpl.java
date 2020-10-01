package com.dhanush.model.service;

import com.dhanush.model.bean.CoffeeSize;
import com.dhanush.model.persistence.SizeDAO;
import com.dhanush.model.persistence.SizeDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class SizeBLImpl implements SizeBL {
    private SizeDAO sizeDAO = new SizeDAOImpl();

    @Override
    public ArrayList<CoffeeSize> getAllCoffeeSize() throws ClassNotFoundException, SQLException {
//        ArrayList<CoffeeSize> coffeesizelist;
//        coffeesizelist = sizeDAO.getAllSize();
//        System.out.println(coffeesizelist.size());
//        ArrayList<CoffeeSize> sizeArrayList = new ArrayList<>();
//        for (CoffeeSize coffeeSize : coffeesizelist) {
//            sizeArrayList.add(coffeeSize);
//        }
//        return sizeArrayList;
        return sizeDAO.getAllSize();
    }

    @Override
    public int getSizePrice(String size) throws ClassNotFoundException, SQLException {
        ArrayList<CoffeeSize> sizeArrayList = getAllCoffeeSize();
        for (CoffeeSize coffeeSize : sizeArrayList) {
            if (coffeeSize.getSize().equalsIgnoreCase(size)) {
                return coffeeSize.getSize_price();
            }

        }
        return 0;
    }
}
