<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vehicle list</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<h1>Vehicles list</h1>
	<table>
		<tr>
			<th>Vehicle type</th>
			<th>Id. Number</th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${vehicles}" var="curVehicle">
			<tr>
				<td>${curVehicle.type.description}</td>
				<td>${curVehicle.identificationNumber}</td>
				<td><a href="<c:url value="/vehicles/${curVehicle.id}" />" >&gt; modify</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>