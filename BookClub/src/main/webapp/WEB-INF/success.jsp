<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>


	<div class="successContainer">
	<div class="header">
		<div>
			<h1>Welcome, <c:out value="${thisUser.userName}"/> </h1>
			<div>
				<p>Books from everyone's shelves:</p>
			</div>
		</div>
		
		<div class="divv">
			<div>
				<a href="/logout">Logout</a>
			</div>
			<div >
				<a href="/books/new">Add a Book to my shelf</a>
			</div>
			
		</div>
	</div>
		
		<div>
	        <table>
	            <thead>
	                <tr>
	                    <th>ID</th>
	                    <th>Title</th>
	                    <th>Author Name</th>
	                    <th>Posted By</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="book" items="${books}">
	                <tr>
	                	<td><c:out value="${book.id}"/></td>
	                	<td><a href="/books/${book.id}/view"><c:out value="${book.title}"/></a></td>                	
	                    <td><c:out value="${book.author}"/></td>
	                    <td><c:out value="${book.user.userName}"/></td>
	                </tr>
	                </c:forEach>
	            </tbody>
	        </table>
	    </div>
    </div>
</body>
</html>
