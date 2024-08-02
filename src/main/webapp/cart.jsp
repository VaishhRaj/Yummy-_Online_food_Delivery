<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page
    import="java.util.List,com.food.model.Cart, com.food.model.CartItem" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<style type="text/css">
h1{
align:center;


}


</style>

<link rel="stylesheet" href="formStyling.css">
<link rel="stylesheet" href="gridModel.css">
</head>
<body align="center">
<h1>Cart</h1>
    <div class="grid">
        <!-- Loop through items and display -->
		<%
   		Cart cart=(Cart) session.getAttribute("cart");
   		if(cart != null && !cart.getItems().isEmpty())
   			
   		{
   			for(CartItem item: cart.getItems().values()){
   		%>            
   		<div class="grid-content">
   				
                <h2><%= item.getName()%></h2>
                <p>Price: <%= item.getPrice() %></p>
                <!-- Add a form for ordering -->
                <form action="cart" method="get">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <input type="hidden" name="itemName" value="<%= item.getName() %>">
                   <lable> Quantity:<input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1">
                    </lable>
                    <input type="submit" name="action" value="update">&nbsp; &nbsp; &nbsp; &nbsp;
                    <input type="submit" name="action" value="remove">
                </form>
                <br><br>
            </div>
        <% } 
   		}else{ %>
   		
        <p>Your Cart is Empty</p>
   		<%
   		} 
   		
   		%>
   		</div>
   		<br><br>
   		<%
   		if(session.getAttribute("restaurantId")!= null)
   		{
   		%>
   		<h4><a href="menu?restaurantId=<%= session.getAttribute("restaurantId") %>">Add More Items</a></h4>
   		<br>
   		<br>
   		 <% } 
   		else{ %>
   		<h4><a href="restaurant.jsp">Add More Items</a></h4>
   		<%
   		} 
   		
   		if(!cart.getItems().isEmpty())
   		{
   		%>
   		<footer>
   		<form action="checkout.jsp" method="post">
   		<p>Total Amount is:<b><%= session.getAttribute("total") %></b></p>
   		<input type="submit" value="Proceed To CheckOut(<%= session.getAttribute("total") %>)">
   		<input type="hidden" name="menuId" value="<%= session.getAttribute("menuId") %>">
   		 <input type="hidden" name="itemName" value="<%= session.getAttribute("itemName") %>" >
   		</form>
   		</footer>
   		<%
   		} 
   		
   		%>
   		
    

</body>
</html>