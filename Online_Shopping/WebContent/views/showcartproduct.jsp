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
<h2> CART PRODUCT DETAILS</h2>
<table border="2" style="padding: 0px;">

<tr>
<th>SNO</th>
<th>CUSTOMER ID</th>
<th>PRODUCT NUMBER</th>
<th>QUANTITY</th>

</tr>    

<c:forEach var="p" items="${list}">
  
      <tr>
      
      <td>
      <h3><c:out value="${p.getSno()}"></c:out></h3>
      </td>
      
      <td>
      <h3><c:out value="${p.getCustomer_id()}"></c:out></h3>
      </td>

      <td>
      <h3><c:out value="${p.getProduct_no()}"></c:out></h3>
      </td>
  


  
      <td>
      <h3><c:out value="${p.getQuantity()}"></c:out></h3>
      </td>
      </tr> 
      </c:forEach>
      </table>
      </center>
</body>
</html>