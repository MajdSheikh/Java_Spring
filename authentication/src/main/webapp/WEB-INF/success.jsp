<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>


<h1>Welcome, ${ thisUser.userName }</h1>
<h3>This is your dashboard. Nothing to see here yet</h3>

<a href="/logout">Logout</a>
</body>
</html>
