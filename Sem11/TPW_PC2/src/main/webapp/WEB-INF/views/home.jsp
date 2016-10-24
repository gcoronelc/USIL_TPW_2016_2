<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>PRACTICA 2</title>
</head>
<body>
	<h1>practica 2</h1>
  <form method="post" action="ConsultarEmpleados.htm">
    <label>Departamento</label>
    <input type="text" name="dpto"/>
    <input type="submit" value="Consultar"/>
  </form>

  <c:forEach items="${lista}" var="r">
  
    <p>${r.nombre}</p>
  </c:forEach>
</body>
</html>
