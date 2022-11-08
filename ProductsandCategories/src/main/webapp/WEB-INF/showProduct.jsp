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
<title>product categories</title>
</head>
<body>
<h1>${product.name }</h1>


<h3>Categories</h3>


        <c:forEach var="product" items="${product.categories}">
        <p><c:out value="${product.name}"></c:out></p>
    	</c:forEach>
    	
 <h1>Add Category</h1>
 
 <form action="/products/addcategory" method="post" >  
 <input type="hidden" name="product" value="${product.id}"/>	
  <select name="category">
        <c:forEach var="category" items="${categories}">
        <option value="${category.id}"><c:out value="${category.name}"></c:out></option>
    	</c:forEach>
        </select>
        <input type="submit" value="Add">
</form>
</body>
</html>