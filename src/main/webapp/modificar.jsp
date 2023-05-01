<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Datos del Cliente</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<link href="<c:url value="/img/favicon.png"></c:url>" rel="icon">

</head>
<body>
	<div class="container">
		<h1>Modificar Datos del Cliente</h1>
		<form action="Controller" method="get"
			class="form-control needs-validation" novalidate id="form2">
			<input hidden type="text"  value="${param.idCliente}" name="idCliente">
			<input hidden type="text" value="modificar" name="opcion">
			
			<div class="mb-3">
				<label for="nombreNuevo" class="form-label">Nombre:</label> <input
					type="text" class="form-control" id="nombreNuevo" name="nombreNuevo"
					placeholder="Ej: Maria Carolina" required
					pattern="[a-zA-záéíóúÁÉÍÓÚñÑ ]+" value="${param.nombre}">
			</div>
			<div class="mb-3">
				<label for="apellidosNuevo" class="form-label">Apellidos:</label> <input
					type="text" class="form-control" id="apellidosNuevo" name="apellidosNuevo"
					placeholder="Ej: Díaz González" required
					pattern="[a-zA-záéíóúÁÉÍÓÚñÑ ]+" value="${param.apellidos}">
			</div>
			<div class="mb-3">
				<label for="telefonoNuevo" class="form-label">Teléfono:</label> <input
					type="text" class="form-control" id="telefonoNuevo" name="telefonoNuevo"
					placeholder="Ej: 654321098" required pattern="[6-9]{1}[0-9]{8}"
					 value="${param.telefono}"/>
				<div class="invalid-feedback">Ingrese el télefono correcto.
					Ej: 654321234 | 987654321 | 765432123 | 876543212</div>
			</div>
			<div class="col-12">
				<input type="submit" class="btn btn-primary" name="submit"
					value="Enviar">
				<a href="index.jsp" class="btn btn-primary">Volver</a>
			</div>

		</form>
		
		 <c:if test="${not empty msg2}">
			<div class="alert alert-primary" role="alert" id="mensaje2">
				<strong><c:out value="${msg2}"/></strong>
			</div>
		</c:if> 
		
		<script src="<c:url value="/js/script.js" />"></script>
</body>
</html>