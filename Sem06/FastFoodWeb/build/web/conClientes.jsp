<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/egcc.css" rel="stylesheet" type="text/css"/>
    <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
    <title>FASTFOOD</title>
  </head>
  <body>

    <div class="egcc_page">

      <div class="egcc_cabecera">
        <jsp:include page="cebecera.jsp" />
      </div>

      <div class="egcc_menu">
        <jsp:include page="menu/menu.jsp" />
      </div>

      <div class="egcc_contenido">
        <h1>CONSULTA DE CLIENTES</h1>
        <form method="post" action="ClienteTraerCliente">
          Código de cliente:
          <input type="text" name="codigo" />
          <input type="submit" value="Consultar" />
        </form>

        <!-- Si hay error -->
        <c:if test="${requestScope.error != null}">
          <p class="egcc_error">${requestScope.error}</p>
        </c:if>

        <!-- Datos del cliente -->
        <c:if test="${requestScope.bean != null}">
          <h2>Datos del Cliente</h2>
          <table style="margin: 5px; border: #0079b2 solid thin;">
            <tr>
              <td style="width: 150px;" >ID</td>
              <td style="width: 150px;" >${bean.id}</td>
            </tr>
            <tr>
              <td>NOMBRE</td>
              <td>${bean.nombre}</td>
            </tr>
            <tr>
              <td>RUC</td>
              <td>${bean.ruc}</td>
            </tr>
            <tr>
              <td>DIRECCION</td>
              <td>${bean.direccion}</td>
            </tr>
            <tr>
              <td>TELEFONO</td>
              <td>${bean.telefono}</td>
            </tr>
          </table>
        </c:if>

        <!-- Mostrar Pedidos -->
        
        <c:if test="${requestScope.pedidos != null}">
          <h2>Pedidos</h2>
          <table>
            <tr class="egcc_tabla_cabecera">
              <th>DOCUMENTO</th>
              <th>NUMERO</th>
              <th>FECHA</th>
              <th>IMPORTE</th>
              <th>DESCUENTO</th>
              <th>SUBTOTAL</th>
              <th>IMPUESTO</th>
              <th>TOTAL</th>
            </tr>
            <c:set var="estilo" value="egcc_tabla_row1" />
            <c:forEach items="${requestScope.pedidos}" var="r">
              <tr class="${estilo}">
                <td>${r.Documento}</td>
                <td>${r.Numero}</td>
                <td>${r.Fecha}</td>
                <td>${r.Importe}</td>
                <td>${r.Descuento}</td>
                <td>${r.Subtotal}</td>
                <td>${r.IGV}</td>
                <td>${r.Total}</td>
              </tr>
            </c:forEach>  
          </table>
        </c:if>
      </div>

      <div class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </div>

    </div>

  </body>
</html>
