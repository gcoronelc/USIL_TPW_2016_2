<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/egcc.css" rel="stylesheet" type="text/css"/>
    <title>JSP Page</title>
  </head>
  <body>
    <div class="egcc_page">
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
  </body>
</html>
