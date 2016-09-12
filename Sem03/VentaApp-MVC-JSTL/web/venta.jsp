<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/egcc.css" rel="stylesheet" type="text/css"/>
    <title>MIS APLICACIONES</title>
  </head>
  <body>
    <div class="egcc_page">
      <jsp:include page="cebecera.jsp"/>
      
      <div>
        <h1>DATOS DE LA VENTA</h1>
        <form method="post" action="VentaController">
          <table>
            <tr>
              <td>Precio:</td>
              <td><input type="text" name="precio"/></td>
            </tr>
            <tr>
              <td>Cantidad:</td>
              <td><input type="text" name="cant"/></td>
            </tr>
            <tr>
              <td colspan="2">
                <input type="submit" value="Procesar" />
              </td>
            </tr>
          </table>
        </form>
        
        <c:if test="${requestScope.model != null}">
          <h1>RESULTADO</h1>
          <table>
            <tr>
              <td>Precio:</td>
              <td>${requestScope.model.precio}</td>
            </tr>
            <tr>
              <td>Cantidad:</td>
              <td>${requestScope.model.cant}</td>
            </tr>
            <tr>
              <td>Importe:</td>
              <td>${requestScope.model.importe}</td>
            </tr>
            <tr>
              <td>Impuesto:</td>
              <td>${requestScope.model.impuesto}</td>
            </tr>
            <tr>
              <td>Total:</td>
              <td>${requestScope.model.total}</td>
            </tr>
          </table>
        </c:if>
      </div>
      
    </div>
  </body>
</html>
