<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>  

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

<title>Edit TV Show</title>
</head>
<body>
	<div class=wrapper>
		<div class=welcome>
			<h1>Change Your Entry</h1>
			<h6>
				<a href="/dashboard">Back to DashBoard</a>
			</h6>
		</div>
		<div>
		    <form:form action="/updateShow/${show.id}" method="put" modelAttribute="show">
		    	<p>
		    	<form:hidden path="user"/>
		    	</p>
				<p>
					<form:label path="title">Title:</form:label>
					<form:errors class="text-danger" path="title" />
					<form:input path="title" />
				</p>

				<p>
					<form:label path="network">Network:</form:label>
					<form:errors class="text-danger" path="network" />
					<form:input path="network" />
				</p>

				<p>
					<form:label path="description">Description:</form:label>
					<form:errors class="text-danger" path="description" />
					<form:textarea rows="10" cols="60" path="description" />
				</p>
				<form:hidden path="rating" value="5"/>
		    	
		        <button>Update</button>
		    </form:form>

		</div>
		
		<div class="bottomButton">
			<c:if test="${sessionScope.userId == show.user.id}">
				<form:form action="/deleteShow/${show.id}" method="delete">
					<button class="deleteBtn">Delete Show</button>
				</form:form>
			</c:if>
		</div>
	</div>
</body>
</html>