package com.dhanush.model.controller;

import com.dhanush.model.bean.Coffee;
import com.dhanush.model.bean.CoffeeAddOns;
import com.dhanush.model.service.AddonBL;
import com.dhanush.model.service.AddonBLImpl;
import com.dhanush.model.service.CoffeeBLImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowAddonController extends HttpServlet {
    private AddonBL addOnBL;
    private ArrayList<CoffeeAddOns> coffeeAddOns;

  /*  public void showAllAddOns() throws SQLException, ClassNotFoundException {
        addOns = addOnBL.getAllCoffeeAddons();
        System.out.println("Available addOns are: ");
        for(CoffeeAddOns temp: addOns) {
            System.out.println(temp.getAddon_id()+") "+temp.getAddon());
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        addOnBL = new AddonBLImpl();
        ArrayList<CoffeeAddOns> coffeeAddOns = null;
        session.setAttribute("coffeeid", req.getParameter("coffeeid"));
        try {
            coffeeAddOns = addOnBL.getAllCoffeeAddons();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*for(Coffee temp: coffee)
        {
            System.out.println(temp.getCoffee_id()+") "+temp.getCoffee_name()+", Price: "+temp.getCoffee_price());
        }*/
        System.out.println(coffeeAddOns);
        session.setAttribute("addonlist", coffeeAddOns);
        resp.sendRedirect("./AddOn.jsp");
    }
}

