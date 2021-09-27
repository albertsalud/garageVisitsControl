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
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>Repair form</h1>
			</div>
		</div>
		<div class="row">
			<div class="col col-lg-4 col-md-6">
				<c:url value="/repairs/save" var="formURL" />
				<form:form modelAttribute="repairFormDTO" action="${formURL}" method="post">
					<form:hidden path="id" />
					<div class="form-group">
						<label for="repairDate">Date:</label>
						<form:input class="form-control" path="repairDate" />
						<form:errors path="repairDate" />
					</div>
					<div class="form-group">
						<label for="vehicle">Vehicle:</label>
						<form:select class="form-control" path="vehicle" items="${repairFormDTO.vehicles}" itemValue="id" itemLabel="identificationNumber">
						</form:select>
					</div>
					<div class="form-group">
						<label for="vehicleKMs">Vehicle kilometers:</label>
						<form:input class="form-control" path="vehicleKMs" />
						<form:errors path="vehicleKMs" />
					</div>
					<div class="form-group">
						<label for="garage">Garage:</label>
						<form:input class="form-control" path="garage" />
						<form:errors path="garage" />
					</div>
					<div class="form-group">
						<label for="amount">Amount:</label>
						<form:input class="form-control" path="amount" />
						<form:errors path="amount" />
					</div>
					<button type="submit" class="btn">Save</button>
				</form:form>
			</div>
		</div>
	</div>
	<jsp:include page="commonFooter.jsp" />
</body>
</html>