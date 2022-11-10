<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register and login</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>


<h1>Welcome!</h1>
<h3>Join our growing community</h3>

<div class="container">

<div class="registration">
<h1>Register</h1>

<form:form action="/register" method="post" modelAttribute="newUser">

<div>
        <form:label path="userName"> User Name: </form:label>
        <form:errors path="userName"/>
        <form:input path="userName" class="input"/>
</div>

<div>
        <form:label path="email"> Email: </form:label>
        <form:errors path="email"/>
        <form:input path="email"/>
</div>

<div>
        <form:label path="password"> Password: </form:label>
        <form:errors path="password"/>
        <form:input path="password"/>
</div>

<div>
        <form:label path="confirm"> Confirm PW: </form:label>
        <form:errors path="confirm"/>
        <form:input path="confirm"/>
</div>

<div>
    <input type="submit" value="submit"/>
</div>

</form:form>
</div>



<div class="login">

<h1>Log in</h1>

<form:form action="/login" method="post" modelAttribute="newLogin">



<div>
        <form:label path="email"> Email: </form:label>
        <form:errors path="email"/>
        <form:input path="email"/>
</div>

<div>
        <form:label path="password"> Password: </form:label>
        <form:errors path="password"/>
        <form:input path="password"/>
</div>


<div>
    <input type="submit" value="submit"/>
</div>

</form:form>


</div>

</div>

</body>
</html>
