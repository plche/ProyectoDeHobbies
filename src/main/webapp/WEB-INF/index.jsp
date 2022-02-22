<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mi primera aplicación Java/Spring</title>
		<link rel="stylesheet" href="/css/index.css" />
	</head>
	<body>
		<h1><c:out value="${titulo}" /></h1>
		<h3>Lista de personas</h3>
		<ul>
			<c:forEach var="persona" items="${listaPersonas}">
				<li><c:out value="${persona.getNombre()}" /> <c:out value="${persona.getApellido()}" /></li>
			</c:forEach>
		</ul>
		<script src="/js/index.js"></script>
	</body>
</html>