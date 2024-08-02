<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page
    import="java.util.List,com.food.model.Restaurant, com.food.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Food Delivery - Items</title>
    <!-- Add any CSS or external libraries here -->
    <link rel="stylesheet" href="gridModel.css">
    <link rel="stylesheet" href="background.css">
    <style type="text/css">
    	input[type="submit"]:hover {
            background: #d81ee1;
        }
         input[type="submit"] {
            background: #d81ee1;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 3px;
        }
        
     </style>
</head>
<body>
<header>
<h1 align="center"> Yummy!!&#128523; :)</h1>
<p>Online Food Delivery Application</p>
</header>
    <h1 align="center">Available Items</h1>
    <div class="grid">
        <!-- Loop through items and display -->
		<%
   		List<Menu> itemList=(List<Menu>) request.getAttribute("itemList");
   		if(itemList != null)
   			
   		{
   			for(Menu item:itemList){
   		%>            
   		<div class="grid-content">
   				<img src="<%= item.getImagePath()%>" alt="Image of <%= item.getItemName() %>">
                <h2><%= item.getItemName()%></h2>
                <p>Description : <%=item.getDescription() %></p>
                <p>Price: <%= item.getPrice() %></p>
                <!-- Add a form for ordering -->
                <form action="cart" method="get">
                    <input type="hidden" name="itemId" value="<%= item.getMenuId() %>">
                    <input type="submit" value="Add To Cart">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="quantity" value="1">
                </form>
            </div>
        <% } 
   		}else{ %>
        <p>No Items Available at the moment</p>
   		<%
   		} 
   		%>
   		
    </div>
</body>
</html>
