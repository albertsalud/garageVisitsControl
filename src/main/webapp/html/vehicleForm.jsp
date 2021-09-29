<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="commonHeader.jsp" />
<title>Vehicle form</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>Vehicle form</h1>
			</div>
		</div>
		<div class="row">
			<div class="col col-lg-4 col-md-6">
				<c:url value="/vehicles/save" var="formURL" />
				<form:form modelAttribute="vehicleFormDTO" action="${formURL}" method="post">
					<form:hidden path="id" />
					<div class="form-group">
						<label for="type">Vehicle type:</label>
						<form:select class="form-control" path="type" items="${vehicleFormDTO.types}" />
					</div>
					<div class="form-group">
						<label for="identificationNumber">Identification number:</label>
						<form:input class="form-control" path="identificationNumber" />
					</div>
					<button type="submit" class="btn">Save</button>
				</form:form>
			</div>
		</div>
		<c:if test="${not empty vehicleFormDTO.repairs}">
			<div class="row">
				<div class="col">
					<table class="table">
						<tr>
							<th>Repair date</th>
							<th>Garage</th>
							<th>Amount</th>
							<th>%nbsp;</th>
						</tr>
						<c:forEach items="${vehicleFormDTO.repairs}" var="curRepair">
							<tr>
								<td>${curRepair.repairDate}</td>
								<td>${curRepair.garage}</td>
								<td>${curRepair.amount}</td>
								<td>
									<c:if test="${not empty curRepair.billFileName}">
										<a href="<c:url value="/repairs/${curRepair.id}/bill" />" >&gt; Bill</a>
									</c:if>
									&nbsp;
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</c:if>
	</div>
	<jsp:include page="commonFooter.jsp" />
</body>
</html>