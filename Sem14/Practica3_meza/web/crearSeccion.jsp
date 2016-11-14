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
        <h1>CREAR SECCION</h1>
        <form method="post" action="CrearSecion">
          <table>
            <tr>
              <td>Nivel:</td>
              <td>
               <select name="nivel">
                  <option value="0">Seleccionar</option>
                  <c:forEach items="${requestScope.niveles}" var="r">
                    <option value="${r.id}">${r.nombre}</option>
                  </c:forEach>
                </select>
              </td>
            </tr>
            <tr>
              <td>Grado:</td>
              <td>
              <select name="grado">
                  <option value="0">Seleccionar</option>
                  <option value="1">Grado 1</option>
                  <option value="2">Grado 2</option>
                  <option value="3">Grado 3</option>
                  <option value="4">Grado 4</option>
                  <option value="5">Grado 5</option>
                  <option value="6">Grado 6</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Aula:</td>
              <td>
              <select name="aula">
                  <option value="0">Seleccionar</option>
                  <c:forEach items="${requestScope.aulas}" var="r">
                    <option value="${r.id}">${r.nombre}</option>
                  </c:forEach>
                </select>
              </td>
            </tr>
            <tr>
              <td>Periodo:</td>
              <td>
              <select name="periodo">
                  <option value="0">Seleccionar</option>
                  <c:forEach items="${requestScope.periodos}" var="r">
                    <option value="${r.periodo}">${r.nombre}</option>
                  </c:forEach>
                </select>
              </td>
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
        <c:if test="${requestScope.secciones != null}">
          <p>Seccion creada satisfactiramente.</p>
        </c:if>


      </div>

      <div class="egcc_pie">
        <jsp:include page="pie.jsp" />

    </div>

  </body>
</html>
