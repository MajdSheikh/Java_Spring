
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Fruity Loops</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<h1>Fruit Store</h1>
<div class=container>
<table class=table>
<tbody>

<tr class=tr>
<th>Name</th>
<th>Price</th>
</tr>

<tr>

<td>
<c:forEach var="fruits" items="${fruits}">
        <p><c:out value="${fruits.name}"></c:out></p>
</c:forEach>
</td>

<td>
<c:forEach var="fruits" items="${fruits}">
        <p><c:out value="${fruits.price}"></c:out></p>
</c:forEach>
</td>

</tr>

</tbody>
</table>

</div>



</body>
</html>