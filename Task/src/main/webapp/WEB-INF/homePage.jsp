<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Task Manager</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>Welcome, <c:out value="${userName}" /></h1>
	<a href="/logout">Logout</a><br/><br/>

	<table>
	    <thead>
	        <tr>
	            <th>Task</th>
	            <th>Creator</th>
	            <th>Assignee</th>
	            <th>Priority</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${tasks}" var="task">
	        <tr>
	        	<td><a href="/tasks/${task.id}"><c:out value="${task.taskName}"/></a></td>
	        	<td><c:out value="${task.creator}"/></td>
	            <td><c:out value="${task.assignee}"/></td>
	            <td><c:out value="${task.priority}"/></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table><br/>
	<form action="/tasks/new">
		<button>Create Task</button>
	</form>
</body>
</html>