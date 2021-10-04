<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="commonHeader.jsp" />
<title>Vehicle list</title>
<script type="text/javascript">
function confirmDeleteVehicle(){
	return confirm("Selected vehicle and its repairs will be deleted. Continue?");
}
</script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
				<h3>Vehicles list</h3>
			</div>
		</div>
		<c:if test="${not empty message}">
			<div class="row">
				<div class="col">
					<p class="bg-danger text-light">${message}</p>
				</div>
			</div>
		</c:if>
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
					</tr>
					<c:forEach items="${vehicles}" var="curVehicle">
						<tr>
							<td>${curVehicle.type.description}</td>
							<td>${curVehicle.identificationNumber}</td>
							<td>
								<a class="btn" href="<c:url value="/vehicles/${curVehicle.id}" />" >
									<img src="<c:url value="/images/edit.png" />" width="25px" height="25px" title="Edit vehicle data">
								</a>
								<a class="btn" href="<c:url value="/repairs/new?vehicle=${curVehicle.id}" />" >
									<img src="<c:url value="/images/addRepair.png" />" width="25px" height="25px" title="Add new repair">
								</a>
								<a class="btn btn-danger" href="<c:url value="/vehicles/delete?vehicle=${curVehicle.id}" />" onclick="return confirmDeleteVehicle()">
									<img src="<c:url value="/images/trash_white.png" />" width="25px" height="25px" title="Delete vehicle">
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