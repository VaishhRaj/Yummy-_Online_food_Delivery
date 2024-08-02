<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="formStyling.css">
    <link rel="stylesheet" href="background.css">
    
    
</head>
<body>
    <div class="login-box">
    	<h2>Login to Yummy!!&#128523;</h2>
        <form action="login" method="post">
            <input type="text" name="email" placeholder="Enter your email Id" required><br>
            <input type="password" name="password" placeholder="Password" required><br>
            <input type="submit" value="Login">
        </form>
        <p>Don't have Account?
        <a href="createAccount.jsp">Resgister Here</a></p>
         <% if (request.getAttribute("errorMessage") != null) { %>
        <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
        
    <% 
    
         } %>
    </div>
    
</body>
</html>