package com.dhanush.model.service;

import com.dhanush.model.bean.Discount;
import com.dhanush.model.persistence.DiscountDAO;
import com.dhanush.model.persistence.DiscountDAOIml;

import java.sql.SQLException;
import java.util.ArrayList;

public class DiscountBLImpl implements DiscountBL {
    private DiscountDAO discountDAO = new DiscountDAOIml();

    @Override
    public ArrayList<Discount> getFinalDiscount() throws ClassNotFoundException, SQLException {

        return discountDAO.getAllDiscount();
    }

    @Override
    public int getDiscountValue(String dis) throws ClassNotFoundException, SQLException {
        ArrayList<Discount> discountArrayList1 = getFinalDiscount();
        for (Discount coffeediscount : discountArrayList1) {
            if (coffeediscount.getCode().equalsIgnoreCase(dis)) {
                System.out.println("COUPON APPLIED");
                return coffeediscount.getDiscount();
            }
        }
        return 0;
    }

}
