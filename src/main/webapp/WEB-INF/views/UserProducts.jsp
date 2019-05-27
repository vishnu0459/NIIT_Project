<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sfrom" %>
    <%@ include file="UserHomeMainPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="photos/css/UserProduct.css" />
</head>
<body>

<div class="container">
    
    <div class="row">
        <c:forEach var="u" items="${userProduct}">
        <div class="col-md-4 col-sm-6">
            <div class="product-grid">
                <div class="product-image">
                    <a href="displayProduct?pro_id=${u.productId}&pro_sup=${u.productSupplier}">
                        
                        <img alt="no image" src="photos/project/${u.productId}.jpg"  /><br>
                    </a>
                   
                    
                </div>
               
                <div class="product-content">
                    <h3 class="title"><a href="displayProduct?pro_id=${u.productId}&pro_sup=${u.productSupplier}">${u.productName}<br>${u.productDescription}<br></a></h3>
                    <div class="price">Cost:${u.productPrice}.00<br>
                        
                    </div>
                    
                </div>
            </div>
        </div>
     
     </c:forEach>   
    </div>
</div>



</body>
</html>