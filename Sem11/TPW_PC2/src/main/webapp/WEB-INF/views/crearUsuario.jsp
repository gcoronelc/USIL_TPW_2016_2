<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${accion} USUARIO</title>
</head>
<body>
  <form method="post" action="grabarUsuario.htm">
    <h1>${accion} USUARIO</h1>
    <input type="hidden" name="accion" value="${accion}" />
    <input type="hidden" name="id" value="${bean.id}" />
    <table>
      <tr>
        <td>ID</td>
        <td>${bean.id}</td>
      </tr>
      <tr>
        <td>Usuario</td>
        <td><input type="text" name="usuario" value="${bean.usuario}" /></td>
      </tr>
      <tr>
        <td>Clave</td>
        <td><input type="password" name="clave" value="${bean.clave}" /></td>
      </tr>
      <tr>
        <td>Estado</td>
        <td><input type="text" name="estado" value="${bean.estado}" /></td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Procesar"/>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>