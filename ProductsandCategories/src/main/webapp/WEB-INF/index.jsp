<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>


<h1>Home Page</h1>

<div class="border">
<a href="products/new">New Product</a><br>
<a href="categories/new">New Category</a><br>

</div>


<div>

<table>
    <thead>
        <tr>
            <th>Products</th>
            <th>Categories</th>

        </tr>
    </thead>
    <tbody>
    <tr>
    <td>
    <ul>
         <c:forEach var="product" items="${products}"> 
			
				<li><a href="products/${product.id}"><c:out value="${product.name}"/></a></li>
			
		</c:forEach>
	</ul>
	</td>
		
	<td>
    <ul>
         <c:forEach var="category" items="${categories}"> 
			
				<li><a href="categories/${category.id}"><c:out value="${category.name}"/></a></li>
			
		</c:forEach>
	</ul>
	</td>

		
	</tr>
		
    </tbody>
</table>

</div>


</body>
</html>
