<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="commonHeader.jsp" />
<title>Repairs list</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>Repairs list</h1>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a href="<c:url value="/repairs/new" />">&gt; Add new repair</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table">
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
							<td>${curRepair.amount}</td>
							<td>
								<c:if test="${not empty curRepair.billFileName}">
									<a href="<c:url value="/repairs/${curRepair.id}/bill" />" >&gt; Bill</a>
								</c:if>
								&nbsp;
							</td>
							<td><a href="<c:url value="/repairs/${curRepair.id}" />" >&gt; modify</a></td>
							<td><a href="<c:url value="/repairs/delete/${curRepair.id}" />" >&gt; delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="commonFooter.jsp" />
</body>
</html>