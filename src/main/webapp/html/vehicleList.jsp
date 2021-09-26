<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="commonHeader.jsp" />
<title>Vehicle list</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>Vehicles list</h1>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a href="<c:url value="/vehicles/new" />">&gt; Add new vehicle</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table">
					<tr>
						<th>Vehicle type</th>
						<th>Id. Number</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${vehicles}" var="curVehicle">
						<tr>
							<td>${curVehicle.type.description}</td>
							<td>${curVehicle.identificationNumber}</td>
							<td><a href="<c:url value="/vehicles/${curVehicle.id}" />" >&gt; modify</a></td>
							<td><a href="<c:url value="/repairs/new?vehicle=${curVehicle.id}" />" >&gt; add new repair</a></td>
							<td><a href="<c:url value="/vehicles/delete?vehicle=${curVehicle.id}" />" >&gt; delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="commonFooter.jsp" />
</body>
</html>