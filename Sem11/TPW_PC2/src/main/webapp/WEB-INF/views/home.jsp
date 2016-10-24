<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>PRACTICA 2</title>
<link rel="stylesheet" type="text/css" 
href="<c:url value="/resources/css/estilos.css"/>">
</head>
<body>
  <div class="egcc_content">
	<h1>practica 2</h1>
	<form method="post" action="ConsultarEmpleados.htm">
		<label>Departamento</label> 
		<select name="dpto">
		  <c:forEach items="${departamentos}" var="r">
		    <option value="${r.codigo}">${r.nombre}</option>
		  </c:forEach>
		</select>
		<input type="submit" value="Consultar" />
	</form>

	<c:if test="${lista != null}">
		<table class="egcc_table">
			<thead>
				<tr>
					<th>ID</th>
					<th>APELLIDOS</th>
					<th>NOMBRES</th>
					<th>ACCIONES</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="r">
					<tr>
						<td>${r.id}</td>
						<td>${r.apellido}</td>
						<td>${r.nombre}</td>
						<td>
						  <a href="crearUsuario.htm?id=${r.id}"><img  src="<c:url value="/resources/img/usuario.png" />" /></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	</div>
</body>
</html>
