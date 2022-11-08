<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>category products</title>
</head>
<body>
<h1>${category.name }</h1>


<h3>products</h3>


        <c:forEach var="category" items="${category.products}">
        <p><c:out value="${category.name}"></c:out></p>
    	</c:forEach>
    	
 <h1>Add product</h1>
 
 <form action="/categories/addproduct" method="post" >  
 <input type="hidden" name="product" value="${category.id}"/>	
  <select name="product">
        <c:forEach var="product" items="${products}">
        <option value="${product.id}"><c:out value="${product.name}"></c:out></option>
    	</c:forEach>
        </select>
        <input type="submit" value="Add">
</form>
</body>
</html>