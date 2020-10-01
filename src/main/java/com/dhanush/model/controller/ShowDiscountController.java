package com.dhanush.model.controller;

import com.dhanush.model.bean.CoffeeAddOns;
import com.dhanush.model.bean.Discount;
import com.dhanush.model.service.AddonBL;
import com.dhanush.model.service.AddonBLImpl;
import com.dhanush.model.service.DiscountBL;
import com.dhanush.model.service.DiscountBLImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowDiscountController extends HttpServlet {
    private DiscountBL discountBL;
    private ArrayList<Discount> coffeeDiscount;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        discountBL = new DiscountBLImpl();
        ArrayList<Discount> coffeeDiscount = null;
        session.setAttribute("coffeesizeid", req.getParameter("coffeesizeid"));

        try {
            coffeeDiscount = discountBL.getFinalDiscount();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(coffeeDiscount);
        session.setAttribute("discountlist", coffeeDiscount);
        resp.sendRedirect("./Discount.jsp");
    }

}
