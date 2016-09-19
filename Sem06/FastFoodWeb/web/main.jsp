<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/egcc.css" rel="stylesheet" type="text/css"/>
    <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
    <title>JSP Page</title>
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
        Aquí debe ir el contenido.
      </div>
      
      <div class="egcc_pie">
        <jsp:include page="pie.jsp" />
      </div>
      
    </div>
      
  </body>
</html>
