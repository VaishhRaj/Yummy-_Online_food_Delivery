<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment</title>
    <!-- Add any CSS or external libraries here -->
    <link rel="stylesheet" href="background.css">
    <link rel="stylesheet" href="formStyling.css">
</head>
<body>
    <h1>Payment Details</h1>
    <div class="login">
        <form action="processPayment.jsp" method="post">
            <label for="cardNumber">Card Number:</label>
            <input type="text" id="cardNumber" name="cardNumber" required>
            <br>
            <label for="expiryDate">Expiry Date:</label>
            <input type="text" id="expiryDate" name="expiryDate" placeholder="MM/YYYY" required>
            <br>
            <label for="cvv">CVV:</label>
            <input type="text" id="cvv" name="cvv" required>
            <br>
            <label for="amount">Total Amount:</label>
            <input type="text" id="amount" name="amount" value="<%= request.getParameter("totalAmount") %>" readonly>
            <br>
            <input type="submit" value="Pay Now">
        </form>
    </div>
</body>
</html>
