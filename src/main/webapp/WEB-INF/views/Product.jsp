<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@ include file="Header.jsp" %>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<br>
<h1>
  Product Form
</h1>
<br>
<br>
<div>
<sform:form action="addpro" method="POST"  modelAttribute="pro" enctype="multipart/form-data">
<sform:input  path="productName" cssClass="formStyle" placeholder="Product Name" />
 <sform:input  path="productDescription" cssClass="formStyle" placeholder="Product Description" />

 <sform:input  path="productPrice" cssClass="formStyle" placeholder="Product Price" />
<sform:select path="productCategory">
<sform:option value="productCategory">productCategory</sform:option>
<c:forEach var="cat" items="${catList}">
<sform:option value="${cat.categoryName}">${cat.categoryName}</sform:option> </c:forEach>
</sform:select>
 
 
 <sform:select path="productSupplier">
<sform:option value="productSupplier">productSupplier</sform:option>
<c:forEach var="sup" items="${supList}">
<sform:option value="${sup.supplierName}">${sup.supplierName}</sform:option> </c:forEach>
</sform:select>
 
 
 
  <sform:input  path="productId" cssClass="formStyle" type="hidden" />
<br>
<sform:input path="productImage" type="file" />

<div class="text-center">
<br>
                  <input type="submit" class="btn" value="${ButtonName}" >
              </div>
</sform:form>
</div>
</body>
</html>