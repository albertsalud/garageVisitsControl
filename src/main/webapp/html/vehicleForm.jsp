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
	<h1>Vehicle form</h1>
	<p>
		<a href="<c:url value="/vehicles" />">&lt; back to vehicles list</a>
	</p>
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
	<c:if test="${not empty vehicleFormDTO.repairs}">
		<table>
			<tr>
				<th>Repair date</th>
				<th>Amount</th>
			</tr>
			<c:forEach items="${vehicleFormDTO.repairs}" var="curRepair">
				<tr>
					<td>${curRepair.repairDate}</td>
					<td>${curRepair.amount}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<jsp:include page="commonFooter.jsp" />
</body>
</html>