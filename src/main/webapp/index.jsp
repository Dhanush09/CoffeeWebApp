<%--
  Created by IntelliJ IDEA.
  User: dkasarap
  Date: 9/4/2020
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cafe Dhanush</title>
    <style>
        body {
            background-image: url("https://i.pinimg.com/originals/09/52/e9/0952e9d8c44d9e1fcc1e9b6da06ca49c.jpg");
            background-size: cover;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;color: white;font-family: 'Arial Black'">Cafe Dhanush Welcomes You!</h1>
<%--<p>
    <a href="./showCoffee" style="color: white; font-family: Arial">Show All Coffee</a>&nbsp;&nbsp;&nbsp;&nbsp;

</p>--%>
<form style="text-align: center" method="get" action="./showCoffee">
    <input type="submit" value="Order Coffee">
</form>

</body>
</html>
