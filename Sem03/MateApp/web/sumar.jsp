<%@page import="pe.usil.mateapp.model.MateModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <% if( request.getAttribute("model") != null) { %>
        <h1>REPORTE</h1>
        <% MateModel model = (MateModel) request.getAttribute("model"); %>
        <table>
          <tr>
            <td>Número 1:</td>
            <td><%= model.getNum1() %></td>
          </tr>
          <tr>
            <td>Número 2:</td>
            <td><%= model.getNum2() %> <td>
          </tr>
          <tr>
            <td>Suma</td>
            <td><%= model.getRpta() %></td>
          </tr>
        </table>
        <% } %>

      </div>
    </div>
  </body>
</html>
