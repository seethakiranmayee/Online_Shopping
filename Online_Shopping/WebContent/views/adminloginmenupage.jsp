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
<font size=6 color="green">${message}</font>
<h3><a href="productadd.jsp" class="GFG">ADD NEW PRODUCT</a></h3>
<h3><a href="getAllProducts"   class="GFG">DISPLAY ALL PRODUCTS</a></h3>
<h3><a href="particularProduct.jsp"   class="GFG">GET PARTICULAR PRODUCT</a></h3>
<h3><a href="customeradd.jsp"   class="GFG">ADD NEW CUSTOMER ACCOUNT</a></h3>
<h3><a href="removecustomermenu.jsp"   class="GFG">REMOVE CUSTOMER ACCOUNT</a></h3>
</center>
</body>
</html>