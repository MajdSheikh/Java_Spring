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





<div class="divvv">
<div class="head">
		<div>
		<p>${book.title}</p>
		</div>
		<div>
		<a href="/home" type="button">back to the shelves</a>
		</div>

</div>
<div>
		<br>
		<c:if test="${user.id == book.user.id}">
			<p>You read ${book.title} by ${book.author}</p>
			<br>
			<p>Here are your thoughts:</p>
		</c:if>
		<c:if test="${user.id != book.user.id}">
			<p>${book.user.userName} read ${book.title} by ${book.author}</p>
			<br>
			<p>Here are ${book.user.userName}'s thoughts:</p>
		</c:if>

		<div>
			<p>${book.thoughts}</p>
		</div>
</div>
	    
	    <div>    

	    <c:if test="${user.id == book.user.id}">
	    <a href="/books/${book.id}/edit" type="button">Edit</a>
	    
	    
	    <form:form action="/books/${book.id}/delete" method="post"> 
	    	<input type="hidden" name="_method" value="delete">  
	    	<input type="submit" value="Delete">
	    </form:form>
	    
	    
	    
	    </c:if>
	    </div>
	</div>

</body>
</html>
