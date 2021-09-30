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
				<h3>Repairs list</h3>
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
						<th class="d-none d-lg-block d-xl-none">Kilometers</th>
						<th>Amount</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${repairs}" var="curRepair">
						<tr>
							<td>${curRepair.repairDate}</td>
							<td>${curRepair.vehicle.identificationNumber}</td>
							<td>${curRepair.garage}</td>
							<td class="d-none d-lg-block d-xl-none">${curRepair.vehicleKMs}</td>
							<td>${curRepair.amount} &euro;</td>
							<td>
								<c:if test="${not empty curRepair.billFileName}">
									<a class="btn" href="<c:url value="/repairs/${curRepair.id}/bill" />" >
										<img src="<c:url value="/images/document.png" />" width="20px" height="25px" alt="Download bill">
									</a>
								</c:if>
								<a class="btn" href="<c:url value="/repairs/${curRepair.id}" />" >
									<img src="<c:url value="/images/edit.png" />" width="25px" height="25px" alt="Edit repair data">
								</a>	
								<a class="btn btn-danger" href="<c:url value="/repairs/delete?repair=${curVehicle.id}" />" >
									<img src="<c:url value="/images/trash_white.png" />" width="25px" height="25px" alt="Delete repair">
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="commonFooter.jsp" />
</body>
</html>