<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dhanush.model.bean.Coffee" %><%--
  Created by IntelliJ IDEA.
  User: dkasarap
  Date: 9/5/2020
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available Coffee:</title>
</head>
<%--<script>
    function coffeeBill(){

    }
</script>--%>
<body>
<style>
    body {
        background-image: url("data:image/jpeg;base64,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");
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
<h1 align="center" style="font-family: 'Arial Black'"> Available Coffee : </h1>
<table class="content-table" border="3"
       style="border:1px solid black;margin-left:auto;margin-right:auto;background-color: #009879">
    <tr>
        <td style="font-family: 'Arial Black';color: black">Coffee id</td>
        <td style="font-family: 'Arial Black';color: black">Coffee Name</td>
        <td style="font-family: 'Arial Black';color: black">Price</td>
    </tr>

    <% ArrayList<Coffee> coffeelist = (ArrayList<Coffee>) session.getAttribute("coffeelist");
        for (Coffee coffee : coffeelist) {
    %>
    <tr>
        <td style="font-family: 'Arial ';color: black"><%=coffee.getCoffee_id()%>
        </td>
        <td style="font-family: 'Arial ';color: black"><%=coffee.getCoffee_name()%>
        </td>
        <td style="font-family: 'Arial ';color: black"><%=coffee.getCoffee_price()%>
        </td>
    </tr>
    <%}%>
</table>
<form style="text-align: center ; color: white" method="get" action="./showAddon">
    Enter Coffee ID:<input type="number" value="" name="coffeeid" id="coffee">
    <input type="submit" value="Next">

</form>
<form style="text-align: center" method="get" action="index.jsp">
    <input type="submit" value="Back">
</form>
</body>
</html>
