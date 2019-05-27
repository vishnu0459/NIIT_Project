<%@page import="com.vishnu.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@ include file="Header.jsp" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Data</title>
</head>
<body>

<sform:form action="show"  modelAttribute="showcat">
<table border="1">
<tr>
<th>Category Id</th>
<th>Category Name</th>
<th>Category Desc</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach var="cat" items="${showcat}">
    <tr>
        <td>${cat.catergoryId}</td>
        <td>${cat.categoryName}</td>
        <td>${cat.categoryDiscription}</td>
        <td><a href="edit?cat_id=${cat.catergoryId}">edit</a></td>
        <td><a href="del?cat_id=${cat.catergoryId}">delete</a></td>
    </tr>
</c:forEach>
</table>

</sform:form>


</body>
</html>