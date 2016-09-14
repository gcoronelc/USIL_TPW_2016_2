<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    
    <c:if test="${sessionScope.usuario != null}">
      <h1>Hello ${sessionScope.usuario.nombre} </h1>
    </c:if>
      
    <c:if test="${sessionScope.usuario == null}">
      <h1>No hay session activa </h1>      
      <a href="LogonSalir">Cerrar Session</a>
    </c:if>
      
  </body>
</html>
