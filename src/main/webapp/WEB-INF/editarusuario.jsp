<%--
  Created by IntelliJ IDEA.
  User: plche
  Date: 6/03/22
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Editar Usuario</title>
    </head>
    <body>
        <h1>Editar Usuario</h1>
        <form:form action="/usuarios/editar" method="post" modelAttribute="usuario">
            <input type="hidden" name="_method" value="PUT" />
            <div>
                <form:label path="nombre" for="nombre">Nombre:</form:label>
                <form:input path="nombre" type="text" name="nombre" id="nombre" value="${nombre}" />
                <form:errors path="nombre" />
            </div>
            <div>
                <form:label path="apellido" for="apellido">Apellido:</form:label>
                <form:input path="apellido" type="text" name="apellido" id="apellido" value="${apellido}" />
                <form:errors path="apellido" />
            </div>
            <div>
<%--                El valor para el hidden input proviene de nombreUsuario guardado en la sesión--%>
                <form:input path="nombreUsuario" type="hidden" name="nombreUsuario" id="nombreUsuario" value="${nombreUsuario}" />
            </div>
            <div>
                <form:label path="password" for="password">Password:</form:label>
                <form:input path="password" type="password" name="password" id="password" />
                <form:errors path="password" />
            </div>
            <div>
                <form:label path="identificador" for="identificador">Identificador:</form:label>
                <form:input path="identificador" type="number" name="identificador" id="identificador" value="${identificador}" />
                <form:errors path="identificador" />
            </div>
            <button type="submit">Editar usuario</button>
        </form:form>
    </body>
</html>
