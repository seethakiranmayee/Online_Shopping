<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>PRODUCT DETAILS</h2>
<table border="2" style="padding: 0px;">

<tr>
<th>CUSTOMER ID</th>
<th>PRODUCT ID</th>
<th>PRODUCT NAME</th>
<th>PRICE</th>
<th>QUANTITY</th>
<th>DISCOUNT</th>
<th>TOTAL AMOUNT</th>
</tr>

<c:forEach var="b" items="${bill}">
  
      <tr>
      
      <td>
      <h3><c:out value="${b.getCustomer_id() }"></c:out></h3>
      </td>
      
      <td>
      <h3><c:out value="${b.getProduct_no()}"></c:out></h3>
      </td>
      
      <td>
      <h3><c:out value="${b.getProduct_name() }"></c:out></h3>
      </td>
      
      <td>
      <h3><c:out value="${b.getPrice() }"></c:out></h3>
      </td>
      
      <td>
      <h3><c:out value="${b. getQuantity()}"></c:out></h3>
      </td>
      
      <td>
      <h3><c:out value="${b.getDiscount() }"></c:out></h3>
      </td>
      
      <td>
      <h3><c:out value="${b.getTotal_amount()}"></c:out></h3>
      </td>
      
      </tr>
      </c:forEach>
      </table>
      </center>
</body>
</html>