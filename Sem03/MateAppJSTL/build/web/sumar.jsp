<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/egcc.css" rel="stylesheet" type="text/css"/>
    <title>MATEMATICA APP</title>
  </head>
  <body>
    <div class="egcc_page">
      <jsp:include page="cebecera.jsp"/>
      <div>
        <h1>SUMAR</h1>
        <form method="post" action="SumaController">
          <table>
            <tr>
              <td>Número 1:</td>
              <td><input type="text" name="num1"/></td>
            </tr>
            <tr>
              <td>Número 2:</td>
              <td><input type="text" name="num2"/></td>
            </tr>
          </table>
          <input type="submit" value="Procesar" name="btnProcesar" />
        </form>

        <c:if test="${requestScope.model != null}" >        
          <h1>REPORTE</h1>
          <table>
            <tr>
              <td>Número 1:</td>
              <td>${requestScope.model.num1}</td>
            </tr>
            <tr>
              <td>Número 2:</td>
              <td>${requestScope.model.num2}<td>
            </tr>
            <tr>
              <td>Suma</td>
              <td>${requestScope.model.rpta}</td>
            </tr>
          </table>
        </c:if>

      </div>
    </div>
  </body>
</html>
