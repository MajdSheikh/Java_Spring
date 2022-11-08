<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dojos</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>


<h1>New Dojo</h1>
<form:form action="/dojos/new" method="post" modelAttribute="dojo">
    <p>
        <form:label path="name"> Name: </form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    

    <input type="submit" value="Create"/>

</form:form>


</body>
</html>
