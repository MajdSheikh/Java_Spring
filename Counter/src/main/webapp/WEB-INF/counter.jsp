
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Your_server</title>
</head>
<body>

<h1>You have visited <a href="/">http://your_server</a> <c:out value="${countToShow}"></c:out> times </h1>
<h1><a href="/">Test another visit?</a></h1>

</body>
</html>