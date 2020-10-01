<%--
  Created by IntelliJ IDEA.
  User: dkasarap
  Date: 9/6/2020
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Order Has Been Placed</title>
</head>
<body>


Your Order Has Been Placed

<% int orderlist = (int) session.getAttribute("finalbill");
    System.out.println(orderlist);%>
<%=orderlist%>


</body>
</html>
