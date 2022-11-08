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


<h1><c:out value="${dojo.name}"/>Ninjas</h1>

<table>
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="ninjas" items="${dojo.ninjas}"> 
			<tr>
				<td><c:out value="${ninjas.firstname}"/></td>
				<td><c:out value="${ninjas.lastname}"/></td>
				<td><c:out value="${ninjas.age}"/></td>

			</tr>
		</c:forEach>
    </tbody>
</table>

</body>
</html>
