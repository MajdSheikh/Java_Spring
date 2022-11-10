<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit book</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>


	<div>
		<h2>Change Your Entry</h2>
		<a href="/home">back to the shelves</a>
	    <form:form action="/books/${book.id}/update" method="POST" modelAttribute="book">
	    <input type="hidden" name="_method" value="put">
	    	
	        <div>
	            <form:label path="title">Title:</form:label>
	            <form:errors path="title"/>
	            <form:input type="text" path="title"/>
	        </div>
	        <div>
	            <form:label path="author">Author:</form:label>
	            <form:errors path="author" />
	            <form:input  type="text" path="author"/>
	        </div>
	        <div>
	            <form:label path="thoughts">Thoughts:</form:label>
	            <form:errors path="thoughts"/>
	            <form:textarea path="thoughts" rows="5"></form:textarea>
	        </div>
	        <div >
				<form:errors path="user" class="error"/>
				<form:input type="hidden" path="user" value="${user.id}"/>
			</div>
	        <input  type="submit" value="Submit">
	    </form:form>
	</div>
	
	
</body>
</html>
