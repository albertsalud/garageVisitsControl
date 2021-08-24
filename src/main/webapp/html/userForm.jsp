<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User form</title>
</head>
<body>
	<h1>User form</h1>
	<c:url value="/users/save" var="formURL" />
	<form:form modelAttribute="userFormDTO" action="${formURL}" method="post">
		<form:hidden path="id" />
		<p>
			Name:
			<form:input path="name" />
		</p>
		<p>
			Surname:
			<form:input path="surname" />
		</p>
		<p>
			Email:
			<form:input path="email" />
		</p>
		<p>
			Password:
			<form:input path="password" />
		</p>
		<p>
			Repeat password:
			<form:input path="repeatPassword" />
		</p>
		<p>
			<input type="submit" value="Save" />
		</p>
	</form:form>
</body>
</html>