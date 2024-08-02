<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="formStyling.css">
<link rel="stylesheet" href="background.css">
</head>
<body>
<h2 align="center">CheckOut</h2>
<div class="login-box">
	<form action="checkout" method="get">
	<lable >Delivery Address:</lable><br><br>
	<textarea id="address" name="address " required></textarea>
	<br><br>
	<lable>Payment Method:</lable><br><br>
	
	<select name="paymentMethod">
	<option value="UPI">UPI</option>
		<option value="Credit Card">Credit Card</option>
		<option value="Debit Card">Debit Card</option>
		<option value="cash on Delivery">Cash on Delivery</option>
	
	</select><br><br>
	<input type="hidden" name="menuId" value="<%= session.getAttribute("menuId") %>">
	<input type="hidden" name="paymentMethod"  >
	<input type="submit" value="Place Order">
	</form>
</div>
</body>
</html>