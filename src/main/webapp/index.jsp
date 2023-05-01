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
		<h1>Datos del Cliente</h1>
		<form action="Controller" method="post"
			class="form-control needs-validation" novalidate id="form">
			<div class="mb-3">
				<label for="nombret" class="form-label">Nombre:</label> <input
					type="text" class="form-control" id="nombre" name="nombre"
					placeholder="Ej: Maria Carolina" required
					pattern="[a-zA-záéíóúÁÉÍÓÚñÑ ]+" value="${param.nombre}">
			</div>
			<div class="mb-3">
				<label for="apellidos" class="form-label">Apellidos:</label> <input
					type="text" class="form-control" id="apellidos" name="apellidos"
					placeholder="Ej: Díaz González" required
					pattern="[a-zA-záéíóúÁÉÍÓÚñÑ ]+" value="${param.apellidos}">
			</div>
			<div class="mb-3">
				<label for="telefono" class="form-label">Teléfono:</label> <input
					type="text" class="form-control" id="telefono" name="telefono"
					placeholder="Ej: 654321098" required pattern="[6-9]{1}[0-9]{8}" value="${param.telefono}">
				<div class="invalid-feedback">Ingrese el télefono correcto.
					Ej: 654321234 | 987654321 | 765432123 | 876543212</div>
			</div>
			<div class="col-12">
				<input type="submit" class="btn btn-primary" name="submit"
					value="Registrar">
			</div>

		</form>
	 <c:if test="${not empty msg}">
			<div class="alert alert-primary" role="alert" id="mensaje">
			<ul>
			<c:forEach items="${msg}" var="mensaje">
				<li><c:out value="${mensaje}"/></li>
			</c:forEach>
			</ul>
			</div>
		</c:if> 
		
		<c:if test="${not empty clientes}">
			<table class="table table-striped table-hover">
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Teléfono</th>
					<th>Acciones</th>
				</tr>

				<c:forEach var="cli" items="${clientes}">
					<tr>
						<th><c:out value="${cli.idCliente}"></c:out></th>
						<th><c:out value="${cli.nombreC}"></c:out></th>
						<th><c:out value="${cli.apellidosC}"></c:out></th>
						<th><c:out value="${cli.telefonoC}"></c:out></th>
						<th>
						 <a
							href="modificar.jsp?idCliente=${cli.idCliente}&opcion=borrar&nombre=
							${cli.nombreC}&apellidos=${cli.apellidosC}&telefono=${cli.telefonoC}"
							id="modificar" title="Modificar" class="btn"> &#128394;  </a>
						<a
							href="Controller?idCliente=${cli.idCliente}&opcion=borrar"
							id="eliminar" title="Eliminar" class="btn"> &#128465;</a>
							
							</th>
					</tr>
				</c:forEach>

			</table>
		</c:if>

	</div>



	<script src="<c:url value="/js/script.js" />"></script>
</body>
</html>