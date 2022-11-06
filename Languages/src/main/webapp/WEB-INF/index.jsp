<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>



<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="language" items="${languages}"> 
			<tr>
				<td><a href="/languages/<c:out value="${language.id}"/>"><c:out value="${language.name}"/></a></td>
				<td><c:out value="${language.creator}"/></td>
				<td><c:out value="${language.version}"/></td>
				<td><a href="/languages/edit/<c:out value="${language.id}"/>">Edit</a></td>
				
				<td><form action="/languages/${language.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete"></form></td> 

				
			</tr>
		</c:forEach>
    </tbody>
</table>


<div>


<form:form action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="name"> Name: </form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    
     <p>
        <form:label path="creator">Creator: </form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </p>
    
     <p>
        <form:label path="version">Version: </form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>
    
    
    
    <input type="submit" value="Submit"/>

</form:form>

</div>

</body>
</html>
