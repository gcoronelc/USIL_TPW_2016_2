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
                <select name="cat">
                  <option value="0">Seleccionar</option>
                  <c:forEach items="${requestScope.categorias}" var="r">
                    <option value="${r.idCat}">${r.nombre}</option>
                  </c:forEach>
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

        <!-- Si No hay error -->
        <c:if test="${requestScope.codigo != null}">
          <p>El código del artículo es: ${requestScope.codigo}.</p>
        </c:if>


      </div>

      <div class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </div>

    </div>

  </body>
</html>
