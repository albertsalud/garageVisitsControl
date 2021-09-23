<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="commonHeader.jsp" />
<title>User form</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<h1>User form</h1>
	<c:url value="/users/save" var="formURL" />
	<form:form modelAttribute="userFormDTO" action="${formURL}" method="post">
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
			<form:input path="email" readonly="true" />
		</p>
		<p>
			Change password:
			<form:password path="password" />
			<form:errors path="password" />
		</p>
		<p>
			Repeat password:
			<form:password path="repeatPassword" />
		</p>
		<p>
			<input type="submit" value="Save" />
		</p>
	</form:form>
	<jsp:include page="commonFooter.jsp" />
</body>
</html>