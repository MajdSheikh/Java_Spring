<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title><c:out value="${task.taskName}"/></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<a href="/tasks">All Tasks</a>
	<h1>Task: <c:out value="${task.taskName}"/></h1>
	<p><span>Creator:</span> <c:out value="${task.creator}"/></p>
	<p><span>Assignee:</span> <c:out value="${task.assignee}"/></p>
	<p><span>Priority:</span> <c:out value="${task.priority}"/></p>
	<form action="/tasks/${task.id}/edit">
		<button>Edit</button>
	</form><br/>
	<form action="/tasks/${task.id}" method="post">
		<input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
</body>
</html>