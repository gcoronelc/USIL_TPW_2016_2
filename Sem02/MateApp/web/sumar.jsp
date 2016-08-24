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
        
        <h1>REPORTE</h1>
      <table>
        <tr>
          <td>Número 1:</td>
          <td><%= request.getAttribute("n1")%></td>
        </tr>
        <tr>
          <td>Número 2:</td>
          <td><%= request.getAttribute("n2")%></td>
        </tr>
        <tr>
          <td>Suma</td>
          <td><%= request.getAttribute("suma")%></td>
        </tr>
      </table>
      <a href="index.html">Retornar</a>
      
      </div>
    </div>
  </body>
</html>
