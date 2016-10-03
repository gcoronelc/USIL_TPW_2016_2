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
        <h1>CREAR ARTICULO</h1>
        <form method="post" action="CrearArticuloSave">
          <table>
            <tr>
              <td>Categoría:</td>
              <td>
                <select name="cate">
                  <option value="0">Seleccionar</option>
                  <option value="1">Bebidas</option>
                  <option value="2">Carnes</option>
                  <option value="3">Pollo</option>
                  <option value="4">Postres</option>
                  <option value="5">Combos</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Nombre:</td>
              <td><input type="text" name="nombre" /></td>
            </tr>
            <tr>
              <td>Precio:</td>
              <td><input type="text" name="precio" /></td>
            </tr>
            <tr>
              <td colspan="2"><input type="submit" value="Procesar" /></td>
            </tr>
          </table>
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
