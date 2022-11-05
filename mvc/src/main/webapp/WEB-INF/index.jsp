<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rendering All Books</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>


<h1>All Books</h1>
<table>
    <thead>
        <tr class="tr">
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
         <!-- loop over all the books to show the details as in the wireframe! -->
         <c:forEach var="book" items="${books}">
			<tr>
				<td><c:out value="${book.id}"/></td>
				<td><c:out value="${book.title}"/></td>
				<td><c:out value="${book.language}"/></td>
				<td><c:out value="${book.numberOfPages}"/></td>
			</tr>
		</c:forEach>
    </tbody>
</table>

</body>
</html>

