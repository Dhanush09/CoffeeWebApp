package com.dhanush.model.service;

import com.dhanush.model.persistence.CoffeeDAO;
import com.dhanush.model.persistence.CoffeeImpl;
import com.dhanush.model.bean.*;
import com.dhanush.model.persistence.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBLImpl implements OrderBL {
    CoffeeDAO coffeeDAO = new CoffeeImpl();
    SizeDAO sizeDAO = new SizeDAOImpl();
    AddonDAO addonDAO = new AddonDAOImpl();
    OrderDAO orderDAO = new OrderDAOImpl();
    DiscountDAO discountDAO = new DiscountDAOIml();
    private Coffee coffee;
    private CoffeeSize coffeeSize;
    private CoffeeAddOns coffeeAddOns;
    private Discount discount;
    private Order orderVar = new Order();
    private ArrayList<String> details = new ArrayList<>();
    private int bill = 0;

    @Override
    public int getBill(Order order) throws ClassNotFoundException, SQLException {
        return 0;
    }

    @Override
    public int calculateBill(Order order) throws ClassNotFoundException, SQLException {
        coffee = coffeeDAO.getCoffeePrice(order.getCoffee_id());
        System.out.println("Coffee price: " + coffee.getCoffee_price());
        bill += coffee.getCoffee_price();
        coffeeAddOns = addonDAO.searchAddOns(order.getAddon_id());
        System.out.println("Addon price: " + coffeeAddOns.getAddon_price());
        bill += coffeeAddOns.getAddon_price();
        coffeeSize = sizeDAO.getPrice(order.getSize_id());
        System.out.println("Size price: " + coffeeSize.getSize_price());
        bill += coffeeSize.getSize_price();
        discount = discountDAO.searchDiscount(order.getDiscount_id());
        System.out.println("Discount: " + discount.getDiscount());
        bill = bill - discount.getDiscount();
        orderDAO.insertOrder(order, orderVar.getCoffee_id(), orderVar.getSize_id(), orderVar.getAddon_id(), orderVar.getDiscount_id());
        return bill;

    }


    @Override
    public ArrayList getDetails(Order order) throws ClassNotFoundException, SQLException {
        coffee = coffeeDAO.getCoffeePrice(order.getCoffee_id());
        details.add(coffee.getCoffee_name());

        coffeeAddOns = addonDAO.searchAddOns(order.getAddon_id());
        details.add(coffeeAddOns.getAddon());

        coffeeSize = sizeDAO.getPrice(order.getSize_id());
        details.add(coffeeSize.getSize());

        discount = discountDAO.searchDiscount(order.getDiscount_id());
        details.add(discount.getCode());

        return details;
    }
}
