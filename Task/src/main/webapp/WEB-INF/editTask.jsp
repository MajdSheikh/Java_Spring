<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>    
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Task</title>
</head>
<body>
	<a href="/tasks">All Tasks</a>
	<h1>Edit <c:out value="${task.taskName}"/></h1>
	<form:form action="/tasks/${task.id}" method="post" modelAttribute="task">
	    <input type="hidden" name="_method" value="put">
			<p>
		        <form:label path="taskName">Task:</form:label>
		        <form:input path="taskName" value="${task.taskName}"/>
		        <form:errors path="taskName"/>
		    </p>
		    <form:input path="creator" type="hidden" value="${currentUserName}"/>    
		    <p>
		        <form:label path="assignee">Assignee:</form:label>
		        <form:select path="assignee" value="${task.assignee}">
		        	<form:option value="">Select Assignee</form:option>
		            <c:forEach items="${users}" var="user">
					   <form:option value="${user.name}"><c:out value="${user.name}"/></form:option>
		            </c:forEach>
		        </form:select>
		        <form:errors path="assignee"/>
		    </p>
		    <p>
		        <form:label path="priority">Priority:</form:label>
		        <form:select path="priority"  value="${task.priority}">
					   <form:option value="">Select Priority</form:option>
					   <form:option value="High">High</form:option>
					   <form:option value="Medium">Medium</form:option>
					   <form:option value="Low">Low</form:option>
		        </form:select>
		        <form:errors path="priority"/>
		    </p> 
	    <input type="submit" value="Edit"/>
	</form:form>
</body>
</html>