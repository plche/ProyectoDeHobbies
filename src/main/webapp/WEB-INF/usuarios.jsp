<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Usuarios con JPA y SQL</title>
	</head>
	<body>
		<h1>Bienvenido de regreso <c:out value="${nombre}" /> <c:out value="${apellido}" /></h1>
		<h2>Lista de usuarios de nuestra base de datos proyecto_hobbies</h2>
		<ul>
			<c:forEach var="usuario" items="${listaUsuarios}">
				<li>
					<form action="/usuarios/eliminar/${usuario.getNombreUsuario()}" method="post">
						<c:out value="${usuario.getNombre()}" /> <c:out value="${usuario.getApellido()}" />
<%--						El valor de la variable nombreUsuario viene de la sesión--%>
						<c:if test="${usuario.getNombreUsuario() eq nombreUsuario}">
							<a href="/usuarios/editar"><button type="button">Editar</button></a>
						</c:if>
						<input type="hidden" name="_method" value="DELETE" />
						<button type="submit">Eliminar</button>
					</form>
					<ul>
						<c:forEach var="hobby" items="${usuario.getListaHobbies()}">
							<li><c:out value="${hobby.getNombre()}" /></li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
		<div>
			<form action="/usuarios/logout" method="get">
				<button type="submit">Logout</button>
			</form>
		</div>
	</body>
</html>