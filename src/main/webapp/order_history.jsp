
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page
    import="java.util.List,com.food.model.OrderHistory" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <link rel="stylesheet" href="background.css">
    <style type="text/css">
    *{
    font-family: Arial, sans-serif;
    background-color: #ff84ff;
    padding: 20px;
    }
    h2
    {
    color:green;
    
    }
    
    </style>
</head>
<body align="center">
    <h1>Order History</h1>
    <%
        List<OrderHistory> orders = (List<OrderHistory>) request.getAttribute("orderHistory"); 
    	if(!orders.isEmpty()){
    %>
    <table border="1" align="center">
        <tr>
            <th>Order ID</th>
            <th>Order Date</th>
            <th>Item Name</th>
            <th>Quantity</th>
            
            <th>Total Amount</th>
            
            <th>Status</th>
        </tr>
        
        <%
            for (OrderHistory order : orders) {
        %>
        <tr>
            <td><%= order.getOrderId() %></td>
            <td><%= order.getOrderDate() %></td>
            <td><%= order.getItemName() %></td>
            <td><%= order.getQuantity() %></td>
            <td><%= order.getTotalAmount() %></td>
            <td><%= order.getStatus() %></td>
        </tr>
        <% } 
    	}
        else{%>
        <h2 color="green">Order Items on Yummy!!&#128523;</h2>
        	
       <%}%>
    </table>
</body>
</html>
