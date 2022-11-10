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

<title>Add A Show</title>
</head>
<body>
	<div class="wrapper">
		<div class="welcome">
			<h1>Create A New TV Show</h1>
		</div>
		<div>
			<form:form action="/saveShow" method="post" modelAttribute="newShow">
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
				<div class="bottomButton">
					<button>Submit</button>
					<h6><a href="/dashboard">Cancel</a></h6>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>