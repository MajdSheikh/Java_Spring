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


	<p><a href="/languages">dashboard</a></p>
	<p> <c:out value="${language.name}"/></p>
	<p><c:out value="${language.creator}"/></p>
	<p>Vendor: <c:out value="${language.version}"/></p>

<a href="/languages/edit/<c:out value="${language.id}"/>">Edit</a>

<form action="/languages/${language.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete"></form>


</body>
</html>
