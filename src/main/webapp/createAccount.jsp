<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
    <link rel="stylesheet" href="formStyling.css">
    <link rel="stylesheet" href="background.css">
</head>
<body>
	<div class="login-box">
    <h2>Create Account</h2>
    <form method="POST" action="register">
        <label for="username">User Name:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
		<label for="confirm-password">Confirm Password:</label>
        <input type="password" id="confirm-password" name="confirm-password" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br><br>
        <label for="role">Role:</label>
        <input type="radio" id="role" name="role" value="Customer" >Customer
        <input type="radio" id="role" name="role"  value="Restaurant">Restaurant
        <input type="radio" id="role" name="role"  value="Delivery Agent">Delivery Agent
        <br><br>
        
        <input type="submit" value="Create Account">
    </form>
     <% if (request.getAttribute("errorMessage") != null) { %>
        <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
    <%     
     } %>
    </div>
</body>
</html>
