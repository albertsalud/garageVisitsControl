<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="commonHeader.jsp" />
<title>Repair form</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.min.css" />
<script>
$( function() {
	$( "#repairDate" ).datepicker({
		dateFormat: "dd/mm/yy"
	});
} );
</script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
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
			<form:errors path="repairDate" />
		</p>
		<p>
			Vehicle:
			<form:select path="vehicle" items="${repairFormDTO.vehicles}" itemValue="id" itemLabel="identificationNumber">
			</form:select>
		</p>
		<p>
			Vehicle kilometers:
			<form:input path="vehicleKMs" />
			<form:errors path="vehicleKMs" />
		</p>
		<p>
			Garage:
			<form:input path="garage" />
			<form:errors path="garage" />
		</p>
		<p>
			Amount:
			<form:input path="amount" />
			<form:errors path="amount" />
		</p>
		<p>
			<input type="submit" value="Save" />
		</p>
	</form:form>
	<jsp:include page="commonFooter.jsp" />
</body>
</html>