

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Omikuji Form</title>
<link rel="stylesheet" type="text/css" href="/css/style1.css">
</head>
<body>

<h1>Here's Your Omikuji</h1>
<div class="container">
<h3>in <c:out value="${number}"></c:out> years, you will live in <c:out value="${city}"></c:out>
 with <c:out value="${person}"></c:out>, <c:out value="${hobby}"></c:out> for a living. The next time you see a 
 <c:out value="${livingThing}"></c:out>, you will have a good luck. Also, <c:out value="${nice}"></c:out>.</h3>
</div>


</body>
</html>