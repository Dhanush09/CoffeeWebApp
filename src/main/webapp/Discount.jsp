<%@ page import="com.dhanush.model.bean.Discount" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: dkasarap
  Date: 9/6/2020
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available Discount:</title>
</head>
<body>
<style>
    body {
        background-image: url("https://ak.picdn.net/shutterstock/videos/5924222/thumb/1.jpg");
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
<h1 align="center" style="font-family: 'Arial Black'"> Available Discount : </h1>
<table class="content-table" border="3"
       style="border:1px solid black;margin-left:auto;margin-right:auto;background-color: bisque">
    <tr>
        <td style="font-family: 'Arial Black ';color: black">Discount Name</td>
        <td style="font-family: 'Arial Black';color: black">Discount</td>
    </tr>

    <% ArrayList<Discount> discountlist = (ArrayList<Discount>) session.getAttribute("discountlist");
        for (Discount coffee : discountlist) {
    %>
    <tr>

        <td style="font-family: 'Arial ';color: black"><%=coffee.getCode()%>
        </td>
        <td style="font-family: 'Arial ';color: black"><%=coffee.getDiscount()%>
        </td>
    </tr>
    <%}%>
</table>
<form style="text-align: center" method="get" action="./showOrder">
    Enter Discount ID :<input type="number" name="discountid" value="" id="discount">
    <input type="submit" value="Next">
</form>
<form style="text-align: center" method="get" action="Size.jsp">
    <input type="submit" value="Back">
</form>

</body>
</html>
