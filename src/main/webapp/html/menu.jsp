<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container-fluid">
		<span class="navbar-brand">Menú</span>
		<ul class="navbar-nav">
			<li class="nav-item"><a href="<c:url value="/users/me" />">Me</a></li>
			<li class="nav-item"><a href="<c:url value="/vehicles" />">My vehicles</a></li>
			<li class="nav-item"><a href="<c:url value="/repairs" />">My repairs</a></li>
			<li class="nav-item"><a href="<c:url value="/logout" />">Log out</a></li>
		</ul>
	</div>
</nav>