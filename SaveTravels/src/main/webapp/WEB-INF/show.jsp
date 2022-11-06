<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<h1>Expense Details</h1>
	<p><a href="/expenses">Go Back</a></p>
	<p>Expense Name: <c:out value="${expense.name}"/></p>
	<p>Expense Description: <c:out value="${expense.description}"/></p>
	<p>Vendor: <c:out value="${expense.vendor}"/></p>
	<p>Amount Spent: <c:out value="${expense.amount}"/>$</p>


</body>
</html>
