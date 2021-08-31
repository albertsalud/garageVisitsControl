<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div id="menu">
	<ul>
		<li><a href="<c:url value="/users/me" />">Me</a></li>
		<li><a href="<c:url value="/vehicles" />">My vehicles</a></li>
		<li><a href="<c:url value="/repairs" />">My repairs</a></li>
		<li><a href="<c:url value="/logout" />">Log out</a></li>
	</ul>
</div>