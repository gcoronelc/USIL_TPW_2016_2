<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table style="width: 100%; vertical-align: middle;">
  <tr>
    <td><img src="img/lion.jpg" /></td>
    <td style="text-align: center;"><img src="img/frase.png" /></td>
    <td style="text-align: right;">
      Usuario: ${sessionScope.usuario.nombre}<br/>
      <a href="LogonSalir">Salir</a>
    </td>
  </tr>
</table>

