<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/egcc.css" rel="stylesheet" type="text/css"/>
    <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
    <title>COLEGIO</title>
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
        <h1>MODIFICAR AULA</h1>
        <form method="post" action="ModificarAula">
          <table>
              <tr>
              <td>Aula:</td>
              <td>
              <select name="id">
                  <option value="0">Seleccionar</option>
                  <c:forEach items="${requestScope.aulas}" var="r">
                    <option value="${r.id}">${r.id} - ${r.nombre}</option>
                  </c:forEach>
                </select>
              </td>
            </tr>
            <tr>
              <td>Nombre:</td>
              <td>
               <input type="text" name="nombre" />
              </td>
            </tr>
            <tr>
              <td>Piso:</td>
              <td><input type="text" name="piso" /></td>
            </tr>
            <tr>
              <td>Numero:</td>
              <td><input type="text" name="numero" /></td>
            </tr>
            <tr>
              <td>Capacidad:</td>
              <td><input type="text" name="capacidad" /></td>
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
        <c:if test="${requestScope.aula != null}">
          <p>Codigo del aula modificado: ${requestScope.aula}.</p>
        </c:if>


      </div>

      <div class="egcc_pie">
        <jsp:include page="pie.jsp" />

    </div>

  </body>
</html>
