<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sfrom" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
div{
  max-width: 500px;
  margin: auto;
  background: white;
  padding: 10px;
}
</style>
</head>
<body>


<form action="cartProductss" method="post">
<div class="container-fluid">
  
  <div class="row">
 
    <div class="col-sm-6" >
    	<img alt="no image" src="photos/project/${proDetails.productId}.jpg"  width="200" height="200"/><br>
		<input   name="proId" value="${proDetails.productId}" type="hidden">
   		 <input   name="proName" value="${proDetails.productName}" type="hidden">
    	<input  name="proDes"  value="${proDetails.productDescription}" type="hidden">
    	<input  name="proPrice" value="${proDetails.productPrice}" type="hidden">
    	<input  name="proSup" value="${proDetails.productSupplier}" type="hidden">
    	<input  name="supAddress" value="${sup.supplierAddress}" type="hidden">
    	Quantity:<input type="number" min="1" max="10" name="quantity"><br>
 	     <p><b>Product Name :</b>${proDetails.productName}</p>
   		<p><b>Product Description :</b>${proDetails.productDescription}</p>
    	<p><b>Product Price: </b>${proDetails.productPrice}</p> 
    	 <p><b>Supplier:</b>${proDetails.productSupplier}</p> 
     	<p> <b>Supplier Address:</b>${sup.supplierAddress}</p>
    </div>
    
     <div class="col-sm-6" >
			<input type="submit" value="Add to Cart"><c:if test="${lg}"></c:if></input>
				
    		<br>
    </div>
    
    <br><br><br><br>
    
  </div>
</div>

</form>

</body>
</html>