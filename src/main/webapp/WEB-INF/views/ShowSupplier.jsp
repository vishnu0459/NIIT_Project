<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ include file="Header.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr>
<th>Supplier Id</th>
<th>Supplier Name</th>
<th>Supplier Description</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach var="s" items="${showsup}">
    <tr>
        <td>${s.supplierId}</td>
        <td>${s.supplierName}</td>
        <td>${s.supplierDescription}</td>
        <td><a href="edits?sup_id=${s.supplierId}">edit</a></td>
        <td><a href="dele?sup_id=${s.supplierId}">delete</a></td> 
    </tr>
</c:forEach>
</table>


</body>
</html>