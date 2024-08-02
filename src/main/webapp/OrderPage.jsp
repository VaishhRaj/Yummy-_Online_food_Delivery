<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page
    import="java.util.List,com.food.model.OrderItem" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <link rel="stylesheet" href="background.css">
</head>
<body align="center">
    <h1>Order Confirmation</h1>
    <%
    OrderItem orderInfo=(OrderItem) session.getAttribute("orderItem");
		if(orderInfo != null){
    %>
    <div>
    	<p>Thank You for Your Order! :)</p>
    	<p>Order ID:<%=	orderInfo.getOrderId() %> </p>
    
    	
    	<p>Ordered Item:<b><%= orderInfo.getItemName() %></b> </p>
    	<p>Ordered Quantity:<b><%= orderInfo.getQuantity() %></b> </p>
    	<p>Total Amount: <b><%=session.getAttribute("totalAmount") %> </b></p>
    </div>
    <br>
    <%
   		} 
   		%>
   		<a href="restaurant.jsp">Go To Home</a>
</body>
</html>
