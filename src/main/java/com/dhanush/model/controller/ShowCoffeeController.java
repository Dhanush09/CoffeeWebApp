package com.dhanush.model.controller;

import com.dhanush.model.bean.Coffee;
import com.dhanush.model.service.CoffeeBL;
import com.dhanush.model.service.CoffeeBLImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowCoffeeController extends HttpServlet {

    private CoffeeBL coffeeBL;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        coffeeBL = new CoffeeBLImpl();

        ArrayList<Coffee> coffee = null;
        try {
            coffee = coffeeBL.getAllCoffeeNames();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*for(Coffee temp: coffee)
        {
            System.out.println(temp.getCoffee_id()+") "+temp.getCoffee_name()+", Price: "+temp.getCoffee_price());
        }*/
        System.out.println(coffee);
        session.setAttribute("coffeelist", coffee);
        resp.sendRedirect("./Coffee.jsp");
    }

}
