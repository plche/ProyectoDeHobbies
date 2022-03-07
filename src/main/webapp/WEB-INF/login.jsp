<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link rel="stylesheet" href="/css/index.css" />
	</head>
	<body>
		<form action="/usuarios/login" method="post">
			<div>
				<label for="nombreUsuario">Nombre de usuario:</label>
				<input type="text" id="nombreUsuario" name="nombreUsuario" /> <c:out value="${errorNombreUsuario}"/>
			</div>
			<div>
				<label for="password">Password:</label>
				<input type="password" id="password" name="password" /> <c:out value="${errorPassword}"/>
			</div>
			<button type="submit">Login</button>
		</form>
		<div class="error">
			<c:out value="${loginError}"/>
		</div>
	</body>
</html>