<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ include file="UserHomeMainPage.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1" cellspacing="50">



<c:forEach var="c" items="${cartlist}">
<tr>
    <td><img alt="abc" src="photos/project/${c.productId}.jpg"  width="170" height="170"/></td>
   
        <td>${c.productName}</td>
        <td>${c.productDescription}</td>
        <td>${c.productPrice}</td>
        <td>${c.productSupplier}</td>
          <td>Quantity: &nbsp;${c.quantity}</td>
       
        
    </tr>
 </c:forEach>
 </table>
</body>
</html>