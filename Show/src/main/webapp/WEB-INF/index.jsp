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
<title>Show Manager</title>
</head>

<body class=darkMode>
	<div class=wrapper>
		<div class=header>
			<h1 class="blueText">TV Shows Application</h1>
		</div>
		<div class=main>
			<div class=login>
				<h1 class=loginHdr>Register</h1>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<p class=loginRow>
						<form:label path="userName">User Name:</form:label>
						<form:input path="userName" />
					</p>
					<p>
						<form:errors class="text-danger" path="userName" />
					</p>

					<p class=loginRow>
						<form:label path="email">Email:</form:label>
						<form:input path="email" />
					</p>
					<p>
						<form:errors class="text-danger" path="email" />
					</p>

					<p class=loginRow>
						<form:label path="password">Password:</form:label>
						<form:password path="password" />
					</p>
					<p>
						<form:errors class="text-danger" path="password" />
					</p>

					<p class=loginRow>
						<form:label path="confirm">Confirm PW:</form:label>
						<form:password path="confirm" />
					</p>
					<p>
						<form:errors class="text-danger" path="confirm" />
					</p>
					<p class=botBtn>
						<button class=loginBtn>Register</button>
					</p>
				</form:form>
			</div>

			<div class=login>
				<h1 class=loginHdr>Log In</h1>
				<p>Message: <c:out value="${message}">${message}</c:out></p>
				<form:form action="/login" method="post" modelAttribute="newLogin">

					<p class=loginRow>
						<form:label path="email">Email:</form:label>
						<form:input path="email" />
					</p>
					<p>
						<form:errors class="text-danger" path="email" />
					</p>

					<p class=loginRow>
						<form:label path="password">Password:</form:label>
						<form:password path="password" />
					</p>
					<p>
						<form:errors class="text-danger" path="password" />
					</p>

					<p class=botBtn>
						<button class=loginBtn>Log In</button>
					</p>
				</form:form>
			</div>
		</div>
	</div>

</body>

</html>