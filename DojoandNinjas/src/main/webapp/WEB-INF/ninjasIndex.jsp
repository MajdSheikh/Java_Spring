<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ninjas</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>


<h1>New Ninja</h1>
<form:form action="/ninjas/new" method="post" modelAttribute="ninja">

	<form:label path="dojo">Dojo:</form:label> 
	<form:select path="dojo">
	    <c:forEach var="dojo" items="${dojo}">
	<form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
			</c:forEach>
	</form:select>
				

	
    <p>
        <form:label path="firstname"> First Name: </form:label>
        <form:errors path="firstname"/>
        <form:input path="firstname"/>
    </p>
    
      <p>
        <form:label path="lastname"> Last Name: </form:label>
        <form:errors path="lastname"/>
        <form:input path="lastname"/>
    </p>
    
      <p>
        <form:label path="age"> Age: </form:label>
        <form:errors path="age"/>
        <form:input path="age"/>
    </p>
    

    <input type="submit" value="Create"/>

</form:form>




</body>
</html>
