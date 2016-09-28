<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/egcc.css" rel="stylesheet" type="text/css"/>
    <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
    <title>EUREKA BANK</title>
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
        <h1>CONSULTA DE CUENTA</h1>
        <form method="post" action="CuentaTraerCuenta">
          Código de cuenta:
          <input type="text" name="cuenta" />
          <input type="submit" value="Consultar" />
        </form>

        <!-- Si hay error -->
        <c:if test="${requestScope.error != null}">
          <p class="egcc_error">${requestScope.error}</p>
        </c:if>

        <!-- Datos del cliente -->
        <c:if test="${requestScope.bean != null}">
          <h2>Datos de la Cuenta:</h2>
          <table style="margin: 5px; border: #0079b2 solid thin;">
            <tr>
                <td style="width: 200px;" ><b>CUENTA:</b></td>
              <td style="width: 200px;" >${bean.cuenta}</td>
            </tr>
            <tr>
                <td><b>SALDO:</b></td>
              <td>${bean.saldo}</td>
            </tr>
            <tr>
                <td><b>CLIENTE:</b></td>
              <td>${bean.cliente}</td>
            </tr>
            <tr>
                <td><b>MONEDA:</b></td>
              <td>${bean.moneda}</td>
            </tr>
            <tr>
                <td><b>ESTADO:</b></td>
              <td>${bean.estado}</td>
            </tr>
          </table>
        </c:if>


        
        <c:if test="${requestScope.movimientos != null}">
          <h2>Movimientos</h2>
          <table width = 400px>
            <tr class="egcc_tabla_cabecera">
              <th>NUMERO</th>
              <th>FECHA</th>
              <th>TIPO</th>
              <th>ACCION</th>
              <th>IMPORTE</th>
            </tr>
            <c:set var="estilo" value="egcc_tabla_row1" />
            <c:forEach items="${requestScope.movimientos}" var="r">
              <tr class="${estilo}">
                <td>${r.int_movinumero}</td>
                <td>${r.dtt_movifecha}</td>
                <td>${r.vch_tipodescripcion}</td>
                <td>${r.vch_tipoaccion}</td>
                <td>${r.dec_moviimporte}</td>
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

