<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Repair form</title>
</head>
<body>
	<h1>Repair form</h1>
	<p>
		<a href="<c:url value="/repairs" />">&lt; back to repairs list</a>
	</p>
	<c:url value="/repairs/save" var="formURL" />
	<form:form modelAttribute="repairFormDTO" action="${formURL}" method="post">
		<form:hidden path="id" />
		<p>
			Date:
			<form:input path="repairDate" />
		</p>
		<p>
			Vehicle:
			<form:select path="vehicle" items="${repairFormDTO.vehicles}" itemValue="id" itemLabel="identificationNumber">
			</form:select>
		</p>
		<p>
			Amount:
			<form:input path="amount" />
		</p>
		<p>
			<input type="submit" value="Save" />
		</p>
	</form:form>
</body>
</html>