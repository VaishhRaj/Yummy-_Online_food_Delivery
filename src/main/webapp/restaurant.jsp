<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page
    import="java.util.List,com.food.model.Restaurant, com.food.model.User" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Restaurants</title>
	<link rel="stylesheet" href="gridModel.css">
	
<!-- Include any necessary CSS or JavaScript files here -->
</head>
<body>
<header>
<h1 align="center">Welcome to Yummy!!&#128523; :)</h1>
<p>Online Food Delivery Application</p>
    <nav>
    	<a href="restaurant">Home</a>&nbsp;
    	<%
    		User loggedIn=(User)session.getAttribute("user");
    		if(loggedIn != null)
    		{
    	%>
  
    		<a href="cart">View Cart</a> &nbsp;
    		<a href="orderHistory">View Order History</a>&nbsp;
    		<a href="logout">Logout</a>&nbsp;
    	<%
    	} 
    		else
    		{
    	%>
    	<a href="loginPage.jsp">Login</a>&nbsp;
    	<a href="createAccount.jsp">Register</a>
    	<%
    		} 
    	%>
    </nav>
   </header> 
   <h2 align="center">Restaurants</h2>
   
   <section class="grid">
   		<%
   		List<Restaurant> resList=(List<Restaurant>) session.getAttribute("restaurantList");
   		if(resList != null)
   		{
   			
   			for(Restaurant restaurant:resList){
   		%>
   		<div class="grid-content">
   		
   		<img src="<%= restaurant.getImagePath() %>" alt="Image of <%= restaurant.getRestaurantName() %>">
   		<h3><%=restaurant.getRestaurantName() %></h3>
   		<p><%=restaurant.getCuisineType() %><br>
   		
   		<p> Delivery Time:<%=restaurant.getDeliveryTime() %>min</p>
   		<p>Rating:<%=restaurant.getRating() %></p>

   		<a href="menu?restaurantId=<%= restaurant.getRestaurantId() %>">View Menu</a>
   		
   		</div>
   	
   		<%
   		}
   		}
   		else{%>
   		<p align="center">Please Login to View and Order <b>Yummy!! &#128523;</b> Items</p>
   		<%
   		} 
   		%>
   </section>
   
</body>
</html>
