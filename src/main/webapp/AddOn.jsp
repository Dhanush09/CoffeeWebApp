<%@ page import="com.dhanush.model.bean.CoffeeAddOns" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: dkasarap
  Date: 9/5/2020
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddOn</title>
</head>
<body>
<style>
    body {
        background-image: url("https://images.summitmedia-digital.com/yummyph/images/2016/06/15/CoffeeAddOns-Labels.jpg");
        background-size: cover;
    }

    * {
        font-family: sans-serif;
    }

    .content-table {
        border-collapse: collapse;
        margin: 25px 0;
        font-size: 0.9em;
        min-width: 400px;
        border-radius: 5px 5px 0 0;
        overflow: hidden;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
    }

    .content-table thead tr {
        background-color: #009879;
        color: #ffffff;
        text-align: left;
        font-weight: bold;
    }

    .content-table th,
    .content-table td {
        padding: 12px 15px;
    }

    .content-table tbody tr {
        border-bottom: 1px solid #dddddd;
    }

    .content-table tbody tr:nth-of-type(even) {
        background-color: #f3f3f3;
    }

    .content-table tbody tr:last-of-type {
        border-bottom: 2px solid #009879;
    }

    .content-table tbody tr.active-row {
        font-weight: bold;
        color: #009879;
    }

</style>
<h1 align="center" style="font-family: 'Arial Black'"> Available Addons : </h1>
<table class="content-table" border="3"
       style="border:1px solid black;margin-left:auto;margin-right:auto;background-color: bisque">
    <tr>
        <td style="font-family: 'Arial Black ';color: black">Addon id</td>
        <td style="font-family: 'Arial Black ';color: black">Addon Name</td>
        <td style="font-family: 'Arial Black';color: black">Price</td>
    </tr>

    <% ArrayList<CoffeeAddOns> addonlist = (ArrayList<CoffeeAddOns>) session.getAttribute("addonlist");
        for (CoffeeAddOns coffee : addonlist) {
    %>
    <tr>
        <td style="font-family: 'Arial ';color: black"><%=coffee.getAddon_id()%>
        </td>
        <td style="font-family: 'Arial ';color: black"><%=coffee.getAddon()%>
        </td>
        <td style="font-family: 'Arial ';color: black"><%=coffee.getAddon_price()%>
        </td>
    </tr>
    <%}%>
</table>
<form style="text-align: center" method="get" action="./showSize">
    Enter Addon ID:<input type="number" value="" name="coffeeaddid" id="addon">
    <input type="submit" value="Next">
</form>
<form style="text-align: center" method="get" action="Coffee.jsp">
    <input type="submit" value="Back">
</form>
</body>
</html>
