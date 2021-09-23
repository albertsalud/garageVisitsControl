<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Repairs list</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<h1>Repairs list</h1>
	<p><a href="<c:url value="/repairs/new" />">&gt; Add new repair</a>
	<table>
		<tr>
			<th>Date</th>
			<th>Vehicle</th>
			<th>Garage</th>
			<th>Kilometers</th>
			<th>Amount</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${repairs}" var="curRepair">
			<tr>
				<td>${curRepair.repairDate}</td>
				<td>${curRepair.vehicle.identificationNumber}</td>
				<td>${curRepair.garage}</td>
				<td>${curRepair.vehicleKMs}</td>
				<td><a href="<c:url value="/repairs/${curRepair.id}" />" >&gt; modify</a></td>
				<td><a href="<c:url value="/repairs/new?vehicle=${curRepair.vehicle.id}" />" >&gt; add new repair</a></td>
				<td><a href="<c:url value="/repairs/delete/${curRepair.id}" />" >&gt; delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>