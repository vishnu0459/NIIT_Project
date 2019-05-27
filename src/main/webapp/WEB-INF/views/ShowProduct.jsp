<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
       <%@ include file="Header.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sfrom" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>

<sfrom:form >

<table border="1">
<tr>
<th>Product Name</th>
<th>Product Description</th>
<th>Product Price</th>
<th>Product Category</th>
<th>Product Supplier</th>
<th>Product ID</th>
<th>Images</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach var="s" items="${showproduct}">
    <tr>
   
        <td>${s.productName}</td>
        <td>${s.productDescription}</td>
        <td>${s.productPrice}</td>
        <td>${s.productCategory}</td>
        <td>${s.productSupplier}</td>
          <td>${s.productId}</td>
        <td><img alt="abc" src="photos/project/${s.productId}.jpg"  width="100" height="100"/></td>
        <td><a href="editpro?pro_id=${s.productId}">edit</a></td>
        <td><a href="delete?pro_id=${s.productId}">delete</a></td> 
    </tr>
</c:forEach>
</table>
</sfrom:form>
</body>
</html>