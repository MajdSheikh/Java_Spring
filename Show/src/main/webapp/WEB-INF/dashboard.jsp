<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="/css/styles.css">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<title>Show Manager Dashboard</title>
</head>
<body class=darkMode>
	<div class="wrapper">
		<div class="welcome">
			<div class="message">
				<h1>
					Welcome,
					<c:out value="${validUser.userName}"></c:out>
				</h1>
				<h3>${message}</h3>
			</div>
			<div class="links">
				<a href="/logout">Logout</a>
			</div>
		</div>

		<h3>TV Shows</h3>
		<table>
			<thead>
				<tr class="tblHdr">
					<th class="tblHdr">Show</th>
					<th class="tblHdr">Network</th>
					<th class="tblHdr">Average Rating</th>
					<th class="tblHdr">Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allShows}" var="show">
					<tr class="tblRow">
						<td class="tblData"><a href="/viewShow/${show.id}">${show.title}</a></td>
						<td class="tblData"><c:out value="${show.network}"></c:out></td>
						<td class="tblData"><c:out value="${show.rating}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="bottomButton">
			<form:form action="/addShow" method="get">
				<button class="editBtn">Add a Show</button>
			</form:form>
		</div>
	</div>

</body>
</html>