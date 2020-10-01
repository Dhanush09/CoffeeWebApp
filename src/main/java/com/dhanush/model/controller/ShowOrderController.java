package com.dhanush.model.controller;

import com.dhanush.model.bean.*;
import com.dhanush.model.service.OrderBL;
import com.dhanush.model.service.OrderBLImpl;
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

import static java.lang.Integer.parseInt;

public class ShowOrderController extends HttpServlet {
    private OrderBL orderBL;
    // private int coffee;
    private Order order;
    private int cprice;
    private int sprice;
    private int aprice;
    private int dprice;
    private CoffeeSize size;
    private CoffeeAddOns addon;
    private Discount discount;
    private Coffee coffee;
    private int bill;
    // private CoffeeSize size;

    /* public void showSize() throws SQLException, ClassNotFoundException {
         sizeArr = sizeBL.getAllCoffeeSize();
         System.out.println("Available size of coffee are: ");
         for(CoffeeSize temp: sizeArr)
         {
             System.out.println(temp.getSize_id()+" "+temp.getSize()+" "+temp.getSize());
         }
     }*/
   /* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        orderBL = new OrderBLImpl();
        order=new Order();
         coffee =0;
        try {
            coffee = orderBL.calculateBill(order);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*for(Coffee temp: coffee)
        {
            System.out.println(temp.getCoffee_id()+") "+temp.getCoffee_name()+", Price: "+temp.getCoffee_price());
        }*/
       /* System.out.println(coffee);
        session.setAttribute("orderlist",coffee);
        resp.sendRedirect("./Order.jsp");
    }*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        orderBL = new OrderBLImpl();
        order = new Order();
        coffee = new Coffee();
        size = new CoffeeSize();
        addon = new CoffeeAddOns();
        discount = new Discount();
        cprice = 0;
        sprice = 0;
        aprice = 0;
        dprice = 0;
        bill = 0;
        ArrayList<Coffee> coffees = (ArrayList<Coffee>) session.getAttribute("coffeelist");
        System.out.println("HELLO" + coffees);
        String price1 = (String) session.getAttribute("coffeeid");
        String price2 = (String) session.getAttribute("coffeesizeid");
        String price3 = (String) session.getAttribute("coffeeaddid");
        String price4 = req.getParameter("discountid");
        System.out.println("Good " + price1 + " " + price2 + " " + price3 + " " + price4);

        for (Coffee coffee : coffees) {
            if (coffee.getCoffee_id() == Integer.parseInt(price1)) {
                session.setAttribute("coffeeprice", coffee.getCoffee_price());
                cprice = (int) session.getAttribute("coffeeprice");
            }

        }
        ArrayList<CoffeeSize> coffeeSizes = (ArrayList<CoffeeSize>) session.getAttribute("sizelist");
        for (CoffeeSize coffeeSize : coffeeSizes) {
            if (coffeeSize.getSize_id() == Integer.parseInt((price2))) {
                session.setAttribute("sizeprice", coffeeSize.getSize_price());

                sprice = (int) session.getAttribute("sizeprice");
            }


        }
        ArrayList<CoffeeAddOns> coffeeAddOns = (ArrayList<CoffeeAddOns>) session.getAttribute("addonlist");
        for (CoffeeAddOns coffeeAddOns1 : coffeeAddOns) {
            if (coffeeAddOns1.getAddon_id() == Integer.parseInt(price3)) {
                session.setAttribute("addonprice", coffeeAddOns1.getAddon_price());
                aprice = (int) session.getAttribute("addonprice");
            }


        }
        ArrayList<Discount> discounts = (ArrayList<Discount>) session.getAttribute("discountlist");
        for (Discount discount1 : discounts) {
            if (discount1.getDiscount_id() == Integer.parseInt(price4)) {
                session.setAttribute("discountprice", discount.getDiscount());
                dprice = (int) session.getAttribute("discountprice");

            }


        }
        bill = cprice + sprice + aprice - dprice;
        session.setAttribute("finalbill", bill);
        resp.sendRedirect("./Order.jsp");


    }


}
