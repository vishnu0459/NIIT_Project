<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@ include file="Header.jsp" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
/* Make the image fully responsive */
  .carousel-inner img {
      width: 100%;
      height: 100%;
  }
body {
  background-color: #808080;
  font-family: source-sans-pro, sans-serif;
}

h1 {
  margin-left: auto;
  margin-top: 50px;
  text-align: center;
  font-weight: 100;
  font-size: 2.8em;
  color: #ffffff;
}

div {
  width: 500px;
  margin: auto;
}

.formStyle { 
  background-color: #2ecc71;
  padding: 20px; 
  width: 400px; 
  margin-bottom: 20px; 
  border-bottom-width: 1px; 
  border-bottom-style: solid; 
  border-bottom-color: #ecf0f1; 
  border-top-style: none; 
  border-right-style: none; 
  border-left-style: none; 
  font-size: 1em;
  font-weight: 100;
  color: #ffffff;
}

.formButton {
  float: right;
	background-color:#ffffff;
	display:inline-block;
	color:#2ecc71;
	font-size:28px;
	font-weight: 500;
	padding:6px 24px;
  margin-top: 15px;
  margin-right: 60px;
	text-decoration:none;
}

.formButton:hover {
	background-color: #27ae60;
  color:#ffffff;
}

.formButton:active {
	position:relative;
	top:3px;
}

/*To remove the outline that appears on clicking the input textbox*/
input:focus {
  outline: none;
}

/* To format the placeholder text color */
::-webkit-input-placeholder {
   color: #ecf0f1;
}

:-moz-placeholder { /* Firefox 18- */
   color: #ecf0f1;  
}

::-moz-placeholder {  /* Firefox 19+ */
   color: #ecf0f1;  
}

:-ms-input-placeholder {  
   color: #ecf0f1;  
}
.btn {
      width: 138px;
      height: 44px;
      -moz-border-radius: 4px;
      -webkit-border-radius: 4px;
      border-radius: 4px;
      float:right;
   border: 1px solid #3b9b64;
   background: #3b9b64;
   background: -webkit-gradient(linear, left top, left bottom, from(#6da5a3), to(#416b68));
   background: -webkit-linear-gradient(top, #6da5a3, #416b68);
   background: -moz-linear-gradient(top, #6da5a3, #416b68);
   background: -ms-linear-gradient(top, #6da5a3, #416b68);
   background: -o-linear-gradient(top, #6da5a3, #416b68);
   background-image: -ms-linear-gradient(top, #6da5a3 0%, #416b68 100%);
   padding: 10.5px 21px;
   -webkit-border-radius: 6px;
   -moz-border-radius: 6px;
   border-radius: 6px;
   -webkit-box-shadow: rgba(255,255,255,0.1) 0 1px 0, inset rgba(255,255,255,0.7) 0 1px 0;
   -moz-box-shadow: rgba(255,255,255,0.1) 0 1px 0, inset rgba(255,255,255,0.7) 0 1px 0;
   box-shadow: rgba(255,255,255,0.1) 0 1px 0, inset rgba(255,255,255,0.7) 0 1px 0;
   text-shadow: #333333 0 1px 0;
   color: #e1e1e1;
}

.btn:hover {
   border: 1px solid #3b9b64;
   text-shadow: #333333 0 1px 0;
   background: #416b68;
   background: -webkit-gradient(linear, left top, left bottom, from(#77b2b0), to(#416b68));
   background: -webkit-linear-gradient(top, #77b2b0, #416b68);
   background: -moz-linear-gradient(top, #77b2b0, #416b68);
   background: -ms-linear-gradient(top, #77b2b0, #416b68);
   background: -o-linear-gradient(top, #77b2b0, #416b68);
   background-image: -ms-linear-gradient(top, #77b2b0 0%, #416b68 100%);
   color: #fff;
}

.btn:active {
   margin-top:1px;
   text-shadow: #333333 0 -1px 0;
   border: 1px solid #253737;
   background: #6da5a3;
   background: -webkit-gradient(linear, left top, left bottom, from(#416b68), to(#416b68));
   background: -webkit-linear-gradient(top, #416b68, #609391);
   background: -moz-linear-gradient(top, #416b68, #6da5a3);
   background: -ms-linear-gradient(top, #416b68, #6da5a3);
   background: -o-linear-gradient(top, #416b68, #6da5a3);
   background-image: -ms-linear-gradient(top, #416b68 0%, #6da5a3 100%);
   color: #fff;
   -webkit-box-shadow: rgba(255,255,255,0) 0 1px 0, inset rgba(255,255,255,0.7) 0 1px 0;
   -moz-box-shadow: rgba(255,255,255,0) 0 1px 0, inset rgba(255,255,255,0.7) 0 1px 0;
   box-shadow: rgba(255,255,255,0) 0 1px 0, inset rgba(255,255,255,0.7) 0 1px 0;
  }
 </style>
</head>
<body>
<br>
<br>
<br>
<h1>
Supplier Form
</h1>
<br>
<br>
<div>
<sform:form action="sup_1"  modelAttribute="sup">
<sform:input  path="supplierName" cssClass="formStyle" placeholder="Supplier Name" />
 <sform:input  path="supplierDescription" cssClass="formStyle" placeholder="Supplier Description" />
 <sform:input  path="supplierAddress" cssClass="formStyle" placeholder="Supplier Address" />
  <sform:input  path="supplierId" cssClass="formStyle"  type="hidden" />
<br>


<div class="text-center">
                  <input type="submit" class="btn" value="${ButtonName}" >
              </div>
</sform:form>
</div>
</body>
</html>