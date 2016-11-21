<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/egcc.css" rel="stylesheet" type="text/css"/>
    <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
    <title>FACTFOOD</title>
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
        <h1>PROCESO INGRESO</h1>
        <form method="post" action="">
          <div>
            <label>Estudiante:</label>
            <select>
              <option value="0">Seleccione estudiante</option>
              <c:forEach items="${requestScope.listaEst}" var="r">
                <option value="${r.IDEST}">${r.NOMBRE}</option>
              </c:forEach>
            </select>
          </div>
          
          
        </form>
      
      
      
      </div>
      
      <div class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </div>
      
    </div>
      
  </body>
</html>
