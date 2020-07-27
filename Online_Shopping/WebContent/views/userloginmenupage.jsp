<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#EDF5E1">
<style>
.GFG
{
background-color:yellow;
border:2px;
color:green;
text-align:center;
displya:inline-block;
font-size:20px;
margin:20px 30px;
text-decoration:none;
cursor:pointer;
}
</style>
<center>
<font size=6 color="green">${message}</font><br><br>
<h3><a href="cartmenu.jsp" class="GFG">ADD PRODUCT TO CART</a></h3>
<h3><a href="getAvailableProducts" class="GFG">DISPLAY AVAILABLE PRODUCTS</a></h3>
<h3><a href="getcartproducts" class="GFG">DISPLAY PRODUCTS FROM CART</a></h3>
<h3><a href="displaybill" class="GFG">DISPLAY BILL</a></h3>
<h3><a href="paybill" class="GFG">PAY BILL</a></h3>
<h3><a href="walletmenu.jsp" class="GFG">ADD BALANCE TO WALLET</a></h3>
<h3><a href="getbalance" class="GFG">CHECK BALANCE</a></h3>
</center>
</body>
</html>