<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rendering Books</title>
</head>
<body>
	<h1><c:out value="${book}"/></h1>
	<h1><c:out value="${book.title}"/></h1>
	<h1><c:out value="${book.description}"/></h1>
	<h1><c:out value="${book.language}"/></h1>
	<h1><c:out value="${book.numberOfPages}"/></h1>

</body>
</html>