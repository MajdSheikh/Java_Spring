<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Task</title>
</head>
<body>
	<a href="/tasks">All Tasks</a>
	<h1>Create a new task</h1>
	<form:form action="/tasks" method="post" modelAttribute="task">
		<p>
	        <form:label path="taskName">Task:</form:label>
	        <form:input path="taskName"/>
	        <form:errors path="taskName"/>
	    </p>
	    <form:input path="creator" type="hidden" value="${currentUserName}"/>  
	    <p>
	        <form:label path="assignee">Assignee:</form:label>
	        <form:select path="assignee">
	        	<form:option value="">Select Assignee</form:option>
	            <c:forEach items="${users}" var="user">
				   <form:option value="${user.name}"><c:out value="${user.name}"/></form:option>
	            </c:forEach>
	        </form:select>
	        <form:errors path="assignee"/>
	    </p>
	    <p>
	        <form:label path="priority">Priority:</form:label>
	        
	        <form:select path="priority">
				   <form:option value="">Select Priority</form:option>
				   <form:option value="High">High</form:option>
				   <form:option value="Medium">Medium</form:option>
				   <form:option value="Low">Low</form:option>
	        </form:select>
	        <form:errors path="priority"/>
	    </p>
	    <input type="submit" value="Create"/>
	</form:form>
</body>
</html>