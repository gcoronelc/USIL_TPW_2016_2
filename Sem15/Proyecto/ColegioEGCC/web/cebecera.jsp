<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table style="width: 100%; vertical-align: middle;">
  <tr>
    <td><img src="img/logo.jpg" /></td>
    <td style="text-align: center;"><img src="img/oferta.jpg" /></td>
    <td style="text-align: right;">
      Usuario: ${sessionScope.usuario.nombre}<br/>
      <a href="#">Salir</a>
    </td>
  </tr>
</table>

