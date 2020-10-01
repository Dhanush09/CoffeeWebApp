package com.dhanush.model.controller;

import com.dhanush.model.bean.Coffee;
import com.dhanush.model.bean.CoffeeSize;
import com.dhanush.model.service.CoffeeBLImpl;
import com.dhanush.model.service.SizeBL;
import com.dhanush.model.service.SizeBLImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowSizeController extends HttpServlet {
    private SizeBL sizeBL;
    private ArrayList<CoffeeSize> coffee;
    // private CoffeeSize size;

    /* public void showSize() throws SQLException, ClassNotFoundException {
         sizeArr = sizeBL.getAllCoffeeSize();
         System.out.println("Available size of coffee are: ");
         for(CoffeeSize temp: sizeArr)
         {
             System.out.println(temp.getSize_id()+" "+temp.getSize()+" "+temp.getSize());
         }
     }*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        sizeBL = new SizeBLImpl();
        ArrayList<CoffeeSize> coffee = null;
        session.setAttribute("coffeeaddid", req.getParameter("coffeeaddid"));
        try {
            coffee = sizeBL.getAllCoffeeSize();
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
        session.setAttribute("sizelist", coffee);
        resp.sendRedirect("./Size.jsp");
    }

}
