<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="commonHeader.jsp" />
<title>Index</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h3>Welcome!</h3>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<ul class="nav nav-tabs" role="tablist">
				  <li class="nav-item" role="presentation">
				    <button id="log-in-tab" class="nav-link active" data-bs-toggle="tab" data-bs-target="#log-in" role="tab" aria-controls="log-in" aria-selected="true">Registered? Log in!</button>
				  </li>
				  <li class="nav-item" role="presentation">
				    <button id="sign-in-tab" class="nav-link" data-bs-toggle="tab" data-bs-target="#sign-in" role="tab" aria-controls="sign-in" aria-selected="false">Not registered yet? Sign in!</button>
				  </li>
				</ul>
				<div class="tab-content">
						<div class="tab-pane fade show active" id="log-in" role="tabpanel" aria-labelledby="log-in-tab">
							<div class="col col-lg-4 col-md-6">
							<form method="post" action="<c:url value="/login" />">
							 	<div class="form-group">
							 		<label for="username">E-mail:</label>
							 		<input type="text" class="form-control" name="username"/>
							 	</div>
							 	<div class="form-group">
							 		<label for="username">Password:</label>
							 		<input type="password" class="form-control" name="password"/>
							 	</div>
							 	<button type="submit" class="btn">Log in</button>
							</form>
							</div>
						</div>
						<div class="tab-pane fade" id="sign-in" role="tabpanel"aria-labelledby="sign-in-tab">
							<div class="col col-lg-4 col-md-6">
							<c:url value="/signin" var="formURL" />
							<form:form modelAttribute="signinFormDTO" method="post" action="${formURL}" >
								<c:if test="${message != null}">
									<p style="color:red">${message}</p>
								</c:if>
								<div class="form-group">
							 		<label for="name">Name:</label>
							 		<input type="text" class="form-control" name="name"/>
							 		<form:errors path="name" />
							 	</div>
							 	<div class="form-group">
							 		<label for="surname">Surname:</label>
							 		<input type="text" class="form-control" name="surname"/>
							 		<form:errors path="surname" />
							 	</div>
							 	<div class="form-group">
							 		<label for="email">E-mail:</label>
							 		<input type="text" class="form-control" name="email"/>
							 		<form:errors path="email" />
							 	</div>
							 	<div class="form-group">
							 		<label for="password">Password:</label>
							 		<input type="password" class="form-control" name="password"/>
							 		<form:errors path="password" />
							 	</div>
							 	<div class="form-group">
							 		<label for="repeatPassword">Repeat password:</label>
							 		<input type="password" class="form-control" name="repeatPassword"/>
							 		<form:errors path="repeatPassword" />
							 	</div>
							 	<button type="submit" class="btn">Sign in</button>
							</form:form>
							</div>
						</div>
					</div>
			</div>
		</div>
	</div>
	<jsp:include page="commonFooter.jsp" />
</body>
</html>