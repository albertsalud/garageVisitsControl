<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="commonHeader.jsp" />
<title>User form</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>User form</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4 col-md-6">
				<c:url value="/users/save" var="formURL" />
				<form:form modelAttribute="userFormDTO" action="${formURL}" method="post">
					<div class="form-group">
						<label for="name">Name:</label>
						<form:input class="form-control" path="name" />
						<form:errors path="name" cssClass="error"/>
					</div>
					<div class="form-group">
						<label for="surname">Surname:</label>
						<form:input class="form-control" path="surname" />
						<form:errors path="surname" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="email">Email:</label>
						<form:input class="form-control-plaintext" path="email" readonly="true"/>
					</div>
					<div class="form-group">
						<label for="password">Change password:</label>
						<form:password class="form-control" path="password" autocomplete="nope" />
						<form:errors path="password" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="repeatPassword">Repeat password:</label>
						<form:password class="form-control" path="repeatPassword" />
						<form:errors path="repeatPassword" cssClass="error" />
					</div>
					<button type="submit" class="btn">Save</button>
				</form:form>
			</div>
		</div>
	</div>
	<jsp:include page="commonFooter.jsp" />
</body>
</html>