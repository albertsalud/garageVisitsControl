<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vehicle form</title>
</head>
<body>
	<h1>Vehicle form</h1>
	<c:url value="/vehicles/save" var="formURL" />
	<form:form modelAttribute="vehicleFormDTO" action="${formURL}" method="post">
		<form:hidden path="id" />
		<p>
			Vehicle type:
			<form:select path="type" items="${vehicleFormDTO.types}">
			</form:select>
		</p>
		<p>
			Identification number:
			<form:input path="identificationNumber" />
		</p>
		<p>
			<input type="submit" value="Save" />
		</p>
	</form:form>
</body>
</html>