<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<div id="registered">
	<h1>Registered? Log in!</h1>
		<form method="post" action="<c:url value="/login" />">
		 	<p>
		 		E-mail:
		 		<input type="text" name="username"/>
		 	</p>
		 	<p>
		 		Password:
		 		<input type="password" name="password"/>
		 	</p>
		 	<p>
		 		<input type="submit" value="Log in" />
		 	</p>
		</form>
	
	</div>
	<div id="not registered">
		<h1>Not registered yet? Sign in!</h1>
		<c:url value="/signin" var="formURL" />
		<form:form modelAttribute="signinFormDTO" method="post" action="${formURL}" >
			<c:if test="${message != null}">
				<p style="color:red">${message}</p>
			</c:if>
		 	<p>
				Name:
				<form:input path="name" />
				<form:errors path="name" />
			</p>
			<p>
				Surname:
				<form:input path="surname" />
				<form:errors path="surname" />
			</p>
			<p>
				Email:
				<form:input path="email" />
				<form:errors path="email" />
			</p>
			<p>
				Password:
				<form:password path="password" />
				<form:errors path="password" />
			</p>
			<p>
				Repeat password:
				<form:password path="repeatPassword" />
				<form:errors path="repeatPassword" />
			</p>
		 	<p>
		 		<input type="submit" value="Sign in" />
		 	</p>
		</form:form>
	</div>
</body>
</html>