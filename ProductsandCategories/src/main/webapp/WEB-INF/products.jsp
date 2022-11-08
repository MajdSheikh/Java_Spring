<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>products</title>
<link rel="stylesheet" type="text/css" href="/css/products.css">
</head>
<body>


<h1>New Product</h1>
<div class="border">
<a href="/"> Home</a>
</div>
<form:form action="/products/new" method="post" modelAttribute="product" class="form">

    <p>
        <form:label path="name"> Name: </form:label>
        <form:errors path="name"/>
        <form:input path="name" class="input"/>
    </p>
    
      <p>
        <form:label path="description"> description: </form:label>
        <form:errors path="description"/>
        <form:input path="description" class="input"/>
    </p>
    
      <p>
        <form:label path="price"> price: </form:label>
        <form:errors path="price"/>
        <form:input path="price" class="input"/>
    </p>
    

    <input type="submit" value="submit"/>

</form:form>




</body>
</html>
