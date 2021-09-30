<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container-fluid">
		<span class="navbar-brand">
			<h1>GVC App</h1>
		</span>
		<ul class="navbar-nav">
			<li class="nav-item">
				<a href="<c:url value="/users/me" />">
					<img src="<c:url value="/images/user.png" />" width="30px" height="30px" title="Profile">
				</a>
			</li>
			<li class="nav-item">
				<a href="<c:url value="/vehicles" />">
					<img src="<c:url value="/images/car.png" />" width="30px" height="30px" title="My vehicles">
				</a>
			</li>
			<li class="nav-item">
				<a href="<c:url value="/repairs" />">
					<img src="<c:url value="/images/repairs.png" />" width="23px" height="23px" title="My repairs">
				</a>
			</li>
			<li class="nav-item">
				<a href="<c:url value="/logout" />">
					<img src="<c:url value="/images/exit.png" />" width="30px" height="30px" title="Log out">
				</a>
			</li>
		</ul>
	</div>
</nav>